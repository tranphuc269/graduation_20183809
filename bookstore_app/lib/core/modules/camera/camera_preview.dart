import 'dart:io';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../ui/widgets/common_widget.dart';
import '../../helper/dialog_helper.dart';
import '../../helper/general_function.dart';

class PreviewCameraPage extends StatelessWidget {
  const PreviewCameraPage({
    required this.imageFile,
    required this.showInfo,
    Key? key,
  }) : super(key: key);

  final File imageFile;
  final bool showInfo;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: Stack(
        children: [
          Align(
            alignment: Alignment.center,
            child: SizedBox(
              height: MediaQuery.of(context).size.height,
              width: MediaQuery.of(context).size.width,
              child: Image.file(
                File(imageFile.path),
                // fit: BoxFit.cover,
              ),
            ),
          ),
          Align(
            alignment: Alignment.bottomCenter,
            child: Container(
              height: 150,
              width: double.infinity,
              color: Colors.black.withOpacity(0.3),
              padding: const EdgeInsets.all(25),
              child: Stack(
                alignment: Alignment.center,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      CircleIcon(
                        onPressed: () => Get.back(),
                        backgroundColor: Colors.white,
                        icon: const Icon(
                          Icons.close,
                          size: 30,
                          color: Colors.black,
                        ),
                      ),
                      CircleIcon(
                        onPressed: () async {
                          if (showInfo) {
                            await showImageInfo(context);
                          }
                          Get.back(result: File(imageFile.path));
                        },
                        backgroundColor: Colors.white,
                        icon: const Icon(
                          Icons.check,
                          size: 30,
                          color: Colors.black,
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Future<void> showImageInfo(BuildContext context) async {
    // Show Image Info
    String size = await AppFunction.getFileSize(imageFile.path, 2);
    Toast.show('$size, ${imageFile.path}');
  }
}