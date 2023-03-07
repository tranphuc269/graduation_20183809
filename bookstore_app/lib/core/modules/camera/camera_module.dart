import 'dart:io';

import 'package:camera/camera.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:image/image.dart' as img;
import 'package:photo_manager/photo_manager.dart';

import '../../../ui/widgets/common_widget.dart';
import '../../../ui/widgets/image_picker.dart';
import '../../helper/dialog_helper.dart';
import '../../helper/general_function.dart';
import 'camera_preview.dart';

enum CameraType {
  REAR,
  FRONT,
}

T? _ambiguate<T>(T? value) => value;

class CameraModule extends StatefulWidget {
  final CameraType cameraType;
  final bool showInfo;
  final bool originSize;
  final bool useBorder;
  final bool fromGallery;
  final ResolutionPreset resolutionPreset;

  const CameraModule({
    Key? key,
    required this.cameraType,
    required this.showInfo,
    this.resolutionPreset = ResolutionPreset.high,
    required this.originSize,
    required this.useBorder,
    required this.fromGallery,
  }) : super(key: key);

  @override
  _CameraModuleState createState() => _CameraModuleState();
}

class _CameraModuleState extends State<CameraModule>
    with WidgetsBindingObserver, TickerProviderStateMixin {
  CameraController? _cameraController;
  List<CameraDescription>? cameras;
  int? selectedCameraIndex;
  File? lastImageFromGallery;

  late AnimationController _flashModeControlRowAnimationController;
  late Animation<double> _flashModeControlRowAnimation;

  @override
  void initState() {
    super.initState();
    _ambiguate(WidgetsBinding.instance)?.addObserver(this);
    setup();
  }

  @override
  void dispose() {
    super.dispose();
    _ambiguate(WidgetsBinding.instance)?.removeObserver(this);
    _cameraController?.dispose();
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    final CameraController? cameraController = _cameraController;

    // App state changed before we got the chance to initialize.
    if (cameraController == null || !cameraController.value.isInitialized) {
      return;
    }

    if (state == AppLifecycleState.inactive) {
      cameraController.dispose();
    } else if (state == AppLifecycleState.resumed) {
      initController(cameraController.description);
    }
  }

  Future setup() async {
    await initCamera();
    await fetchFirstPhotoFromGallery();
  }

  initCamera() async {
    _flashModeControlRowAnimationController = AnimationController(
      duration: const Duration(milliseconds: 300),
      vsync: this,
    );
    _flashModeControlRowAnimation = CurvedAnimation(
      parent: _flashModeControlRowAnimationController,
      curve: Curves.easeIn,
    );
    debugPrint('CameraModule::initCamera() -> $cameras');
    await availableCameras().then((value) {
      if (value.isNotEmpty) {
        cameras = value;
        if (cameras!.isNotEmpty) {
          if (widget.cameraType == CameraType.REAR) {
            selectedCameraIndex = 0;
          } else {
            selectedCameraIndex = 1;
          }
          initController(cameras![selectedCameraIndex!]).then((_) {});
        } else {
          Toast.show('Kamera tidak ditemukan');
        }
      }
    }).catchError((e) {
      debugPrint('CameraModule::initCamera() -> $e');
      AppDialog.show(
          typeDialog: TypeDialog.FAILED,
          message: 'Terjadi Kesalahan!\n${e.toString()}',
          onPress: () {
            AppDialog.close();
            Get.back();
          });
    });
  }

  Future initController(CameraDescription cameraDescription) async {
    debugPrint('CameraModule::initCamera() cameras.isNotEmpty');
    if (_cameraController != null) {
      await _cameraController!.dispose();
    }
    _cameraController =
        CameraController(cameraDescription, widget.resolutionPreset);
    _cameraController!.addListener(() {
      if (mounted) {
        setState(() {});
      }
    });
    if (_cameraController!.value.hasError) {
      Toast.show('Terjadi kesalahan pada kamera. ()');
    }

    debugPrint('CameraModule::initCameraController()');
    try {
      _cameraController!.initialize();
    } catch (e) {
      debugPrint('CameraException::initCameraController() ${e.toString()}');
      Toast.show('Terjadi kesalahan pada kamera.\n$e');
    }
    debugPrint('CameraModule::initCamera() _controller.initialize');
    if (mounted) {
      setState(() {});
    }
  }

  Future fetchFirstPhotoFromGallery() async {
    try {
      final albums = await PhotoManager.getAssetPathList(type: RequestType.all);
      final recentAlbum = albums.first;
      final recentAssets = await recentAlbum.getAssetListRange(
        start: 0,
        end: 1,
      );
      final image = await recentAssets.first.file;
      setState(() {lastImageFromGallery = image;});
    } catch (e) {
      debugPrint('e: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: SafeArea(
        child: Stack(
          alignment: Alignment.center,
          children: [
            Align(
              alignment: Alignment.center,
              child: _cameraPreview(),
            ),
            Align(
              alignment: Alignment.topCenter,
              child: Container(
                padding: const EdgeInsets.all(6),
                color: Colors.black.withOpacity(0.3),
                // color: primaryColor,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    IconButton(
                      icon: const Icon(Icons.arrow_back, color: Colors.white),
                      onPressed: () => Get.back(),
                    ),
                    const Spacer(),
                    _flashModeControlRowWidget(),
                    _flashCameraButton(),
                  ],
                ),
              ),
            ),
            Align(
              alignment: Alignment.bottomCenter,
              child: Container(
                height: 120,
                width: double.infinity,
                color: Colors.black.withOpacity(0.3),
                padding: const EdgeInsets.all(25),
                child: Stack(
                  alignment: Alignment.center,
                  children: [
                    _cameraButton(context),
                    _switchCameraButton(),
                    _buildGalleryButton(),
                  ],
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  Widget _cameraPreview() {
    if (_cameraController == null || !_cameraController!.value.isInitialized) {
      return platformLoadingIndicator();
    }
    final camera = _cameraController!.value;
    final size = MediaQuery.of(context).size;
    var scale = size.aspectRatio * camera.aspectRatio;
    if (scale < 1) scale = 1 / scale;
    if (widget.useBorder) {
      return Stack(
        children: [
          Center(
            child: CameraPreview(_cameraController!),
          ),
          Column(
            children: [
              Container(
                height: (MediaQuery.of(context).size.height -
                    MediaQuery.of(context).size.width) /
                    2 -
                    15,
                color: Colors.black.withOpacity(0.3),
              ),
              Center(
                child: AspectRatio(
                  aspectRatio: MediaQuery.of(context).size.width /
                      MediaQuery.of(context).size.width,
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: CustomPaint(
                      foregroundPainter: BorderPainter(),
                    ),
                  ),
                ),
              ),
              Container(
                height: (MediaQuery.of(context).size.height -
                    MediaQuery.of(context).size.width) /
                    2 -
                    15,
                color: Colors.black.withOpacity(0.3),
              ),
            ],
          ),
        ],
      );
    } else {
      return Transform.scale(
        scale: scale,
        child: Center(
          child: CameraPreview(_cameraController!),
        ),
      );
    }
  }

  Widget _cameraButton(context) {
    return Align(
      alignment: Alignment.topCenter,
      child: InkWell(
        onTap: () => onCapture(context),
        child: Container(
          padding: const EdgeInsets.all(4),
          decoration: BoxDecoration(
            border: Border.all(color: Colors.white, width: 2.0),
            shape: BoxShape.circle,
          ),
          child: const CircleAvatar(
            child: Icon(
              Icons.camera,
              size: 55,
              color: Colors.white,
            ),
            radius: 35,
            backgroundColor: Colors.black,
          ),
        ),
      ),
    );
  }

  Widget _buildGalleryButton() {
    final image = (lastImageFromGallery != null)
        ? FileImage(lastImageFromGallery!)
        : null;
    return Visibility(
      visible: widget.fromGallery,
      child: Container(
        margin: const EdgeInsets.only(left: 20),
        child: Align(
          alignment: Alignment.bottomLeft,
          child: UiImagePicker(
            withCompression: true,
            sizeLimit: 2000000,
            onSelected: (image) {
              toPreview(resultImage: image);
            },
            child: Container(
              width: 50,
              height: 50,
              decoration: BoxDecoration(
                  color: image != null ? Colors.white : Colors.grey[300],
                  borderRadius: BorderRadius.circular(8),
                  image: image != null ? DecorationImage(
                      fit: BoxFit.cover,
                      image: image
                  ) : null
              ),
            ),
          ),
        ),
      ),
    );
  }

  onCapture(context) async {
    try {
      final CameraLensDirection lensDirection =
          cameras![selectedCameraIndex!].lensDirection;
      await _cameraController!.takePicture().then((value) async {
        File imageCaptured;
        if (lensDirection == CameraLensDirection.front) {
          imageCaptured = await flipSelfieImage(value);
        } else {
          imageCaptured = File(value.path);
        }
        toPreview(resultImage: imageCaptured);
      });
    } catch (e) {
      debugPrint('Error : ${e.toString()}');
    }
  }

  toPreview({required File resultImage}) async {
    dynamic arguments;
    if (widget.originSize) {
      arguments = Get.to(() => PreviewCameraPage(
        imageFile: resultImage,
        showInfo: widget.showInfo,
      ));
    } else {
      final cropedImg = await squareCropImage(resultImage);
      arguments = Get.to(() => PreviewCameraPage(
        imageFile: cropedImg,
        showInfo: widget.showInfo,
      ));
    }
    arguments?.then((value) {
      if (value != null) {
        Get.back(result: value);
      }
    });
  }

  Future<File> squareCropImage(File image) async {
    final img.Image? capturedImage = img.decodeImage(await image.readAsBytes());
    final croppedImg = img.copyResizeCropSquare(capturedImage!, 1080);
    final File result = await image.writeAsBytes(img.encodeJpg(croppedImg));
    return result;
  }

  Future<File> flipSelfieImage(XFile image) async {
    final img.Image? capturedImage =
    img.decodeImage(await File(image.path).readAsBytes());

    // final img.Image orientedImage = img.flipHorizontal(capturedImage!);

    final croppedImage = img.copyResizeCropSquare(capturedImage!, 1080);
    final img.Image orientedImage = img.flipHorizontal(croppedImage);

    final File flipedImage =
    await File(image.path).writeAsBytes(img.encodeJpg(orientedImage));
    return flipedImage;
  }

  // ---------------------------------------------------------------
  //                     CHANGE CAMERA MODE
  // ---------------------------------------------------------------

  Widget _switchCameraButton() {
    if (cameras == null) {
      return Container();
    }
    final CameraDescription selectedCamera = cameras![selectedCameraIndex!];
    final CameraLensDirection lensDirection = selectedCamera.lensDirection;
    return Container(
      margin: const EdgeInsets.only(right: 20),
      child: Align(
        alignment: Alignment.bottomRight,
        child: CircleIcon(
          onPressed: () => onSwitchCamera(),
          backgroundColor: Colors.black54.withOpacity(0.8),
          icon: Icon(
            getCameraLensIcon(lensDirection),
            size: 30,
            color: Colors.white,
          ),
        ),
      ),
    );
  }

  IconData getCameraLensIcon(CameraLensDirection lensDirection) {
    switch (lensDirection) {
      case CameraLensDirection.back:
        return CupertinoIcons.switch_camera;
      case CameraLensDirection.front:
        return CupertinoIcons.switch_camera;
      case CameraLensDirection.external:
        return CupertinoIcons.switch_camera;
      default:
        return Icons.device_unknown;
    }
  }

  onSwitchCamera() {
    selectedCameraIndex = selectedCameraIndex! < cameras!.length - 1
        ? selectedCameraIndex! + 1
        : 0;
    final CameraDescription selectedCamera = cameras![selectedCameraIndex!];
    initController(selectedCamera);
  }

  // ---------------------------------------------------------------
  //                          FLASH MODE
  // ---------------------------------------------------------------

  Widget _flashCameraButton() {
    if (cameras == null) {
      return Container();
    }
    return Container(
      margin: const EdgeInsets.only(right: 10),
      child: CircleIcon(
        onPressed: () => onFlashModeButtonPressed(),
        backgroundColor: Colors.black54.withOpacity(0),
        icon: const Icon(
          Icons.flash_on,
          size: 30,
          color: Colors.white,
        ),
      ),
    );
  }

  onFlashModeButtonPressed() {
    if (_flashModeControlRowAnimationController.value == 1) {
      _flashModeControlRowAnimationController.reverse();
    } else {
      _flashModeControlRowAnimationController.forward();
    }
  }

  Widget _flashModeControlRowWidget() {
    return SizeTransition(
      sizeFactor: _flashModeControlRowAnimation,
      child: ClipRect(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          mainAxisSize: MainAxisSize.max,
          children: <Widget>[
            IconButton(
              icon: const Icon(Icons.flash_off),
              color: _cameraController?.value.flashMode == FlashMode.off
                  ? Colors.orange
                  : Colors.blue,
              onPressed: _cameraController != null
                  ? () => onSetFlashModeButtonPressed(FlashMode.off)
                  : null,
            ),
            IconButton(
              icon: const Icon(Icons.flash_auto),
              color: _cameraController?.value.flashMode == FlashMode.auto
                  ? Colors.orange
                  : Colors.blue,
              onPressed: _cameraController != null
                  ? () => onSetFlashModeButtonPressed(FlashMode.auto)
                  : null,
            ),
            IconButton(
              icon: const Icon(Icons.flash_on),
              color: _cameraController?.value.flashMode == FlashMode.always
                  ? Colors.orange
                  : Colors.blue,
              onPressed: _cameraController != null
                  ? () => onSetFlashModeButtonPressed(FlashMode.always)
                  : null,
            ),
            IconButton(
              icon: const Icon(Icons.highlight),
              color: _cameraController?.value.flashMode == FlashMode.torch
                  ? Colors.orange
                  : Colors.blue,
              onPressed: _cameraController != null
                  ? () => onSetFlashModeButtonPressed(FlashMode.torch)
                  : null,
            ),
          ],
        ),
      ),
    );
  }

  void onSetFlashModeButtonPressed(FlashMode mode) {
    setFlashMode(mode).then((_) {
      if (mounted) {
        setState(() {});
      }
    });
  }

  Future<void> setFlashMode(FlashMode mode) async {
    if (_cameraController == null) {
      return;
    }

    try {
      await _cameraController!.setFlashMode(mode);
    } on CameraException catch (e) {
      logError(e.code, e.description);
      Toast.show('Error: ${e.code}\n${e.description}');
      rethrow;
    }
  }

  void logError(String code, String? message) {
    if (message != null) {
      debugPrint('Error: $code\nError Message: $message');
    } else {
      debugPrint('Error: $code');
    }
  }
}