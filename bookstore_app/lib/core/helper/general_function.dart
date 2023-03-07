

import 'dart:io';
import 'dart:math';
import 'dart:typed_data';

import 'package:dio/dio.dart';
import 'package:file_picker/file_picker.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:open_filex/open_filex.dart';
import 'package:path_provider/path_provider.dart';
import 'package:flutter_image_compress/flutter_image_compress.dart';
import 'package:image/image.dart' as img;

import '../database/secure_storage/secure_storage_manager.dart';
import '../network/api_request.dart';

class AppFunction {
  static Future<String> getFileSize(String filepath, int decimals) async {
    final file = File(filepath);
    final int bytes = await file.length();
    debugPrint('Path : $filepath');
    debugPrint('Size : $bytes');
    if (bytes <= 0) {
      return '0 B';
    }
    const suffixes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
    final i = (log(bytes) / log(1024)).floor();
    return ((bytes / pow(1024, i)).toStringAsFixed(decimals)) + suffixes[i];
  }

  static Future<Uint8List> compressBytes(Uint8List list) async {
    final result = await FlutterImageCompress.compressWithList(
      list,
      minHeight: 1920,
      minWidth: 1080,
      quality: 20,
    );
    debugPrint(list.length.toString());
    debugPrint(result.length.toString());
    return result;
  }

  static Future<File> compressImage(
      {required File file, required int limit}) async {
    const minLimit = 1000000;
    if (limit < minLimit) {
      limit = minLimit;
    }
    var size = file.lengthSync();
    while (size >= limit) {
      final result = await FlutterImageCompress.compressWithFile(
        file.absolute.path,
        minWidth: 1024,
        minHeight: 1024,
        quality: 80,
      );
      final image = img.decodeJpg(result!)!;
      File(file.path).writeAsBytesSync(img.encodePng(image));
      size = file.lengthSync();
    }
    return file;
  }

  // Download File
  static Future<File> downloadFile(
      {required String url, bool useToken = false, name}) async {
    var fileName = 'downloaded_file';
    if (name != null) {
      fileName = name;
    }
    try {
      if (useToken) {
        final String? token = await SecureStorageManager.find.getToken();
        headers[HttpHeaders.authorizationHeader] = 'Bearer $token';
      } else {
        headers.clear();
      }
      final rs = await Dio().get<List<int>>(url,
          options: Options(responseType: ResponseType.bytes, headers: headers));
      final dir = await getApplicationDocumentsDirectory();
      final File file = File('${dir.path}/$fileName.pdf');
      final File urlFile = await file.writeAsBytes(rs.data!);
      return urlFile;
    } catch (e) {
      debugPrint('Error : $e');
      throw Exception('Error opening url file');
    }
  }

  static Future<String> downloadFilePath(String url, String fileName) async {
    final directory = await getApplicationDocumentsDirectory();
    final filePath = '${directory.path}/$fileName';
    await Dio().download(url, filePath);
    return filePath;
  }

  static Future<void> openFile({required String url, String? fileName}) async {
    final name = fileName ?? url.split('/').last;
    final file = await downloadFilePath(url, name);
    debugPrint('Path : $file');
    await OpenFilex.open(file);
  }

  // ----------------------------------------------------------------------------------------
  //                                 File/Image Picker
  // ----------------------------------------------------------------------------------------

  static Future<File?> imagePicker(
      ImageSource source, ImagePicker imagePicker) async {
    final XFile? _pickedFile = await imagePicker.pickImage(
      source: source,
      imageQuality: 40,
    );
    return File(_pickedFile!.path);
  }

  static Future<File?> takeVideo(
      ImageSource source,
      ImagePicker filePicker,
      ) async {
    final XFile? _pickedFile = await filePicker.pickVideo(
      source: source,
      preferredCameraDevice: CameraDevice.rear,
      maxDuration: const Duration(seconds: 20),
    );
    return File(_pickedFile!.path);
  }

  static Future<File?> pickFile(BuildContext context, String type) async {
    final FilePickerResult? result = await FilePicker.platform
        .pickFiles(type: FileType.custom, allowedExtensions: ['pdf']);
    if (result != null) {
      final File file = File(result.files.single.path!);
      return file;
    }
    return null;
  }
}

class BorderPainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    final double sh = size.height;
    final double sw = size.width;
    final double cornerSide = sh * 0.07;

    final Paint paint = Paint()
      ..color = Colors.black
      ..strokeWidth = 2.5
      ..style = PaintingStyle.stroke
      ..strokeCap = StrokeCap.round;

    final Path path = Path()
      ..moveTo(cornerSide, 0)
      ..quadraticBezierTo(0, 0, 0, cornerSide)
      ..moveTo(0, sh - cornerSide)
      ..quadraticBezierTo(0, sh, cornerSide, sh)
      ..moveTo(sw - cornerSide, sh)
      ..quadraticBezierTo(sw, sh, sw, sh - cornerSide)
      ..moveTo(sw, cornerSide)
      ..quadraticBezierTo(sw, 0, sw - cornerSide, 0);

    canvas.drawPath(path, paint);
  }

  @override
  bool shouldRepaint(BorderPainter oldDelegate) => false;

  @override
  bool shouldRebuildSemantics(BorderPainter oldDelegate) => false;
}

class MyHttpOverrides extends HttpOverrides {
  @override
  HttpClient createHttpClient(SecurityContext? context) {
    return super.createHttpClient(context)
      ..badCertificateCallback =
          (X509Certificate cert, String host, int port) => true;
  }
}