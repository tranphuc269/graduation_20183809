import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import '../../ui/widgets/base_dialog.dart';
import '../localization/language_const.dart';

//---------------<Toast>-----------------
class Toast {
  static show(String message) {
    Fluttertoast.showToast(msg: message);
  }
}

//---------------<Loading Dialog>-----------------
class Loading {
  static Future show({bool? dismissible}) {
    return showDialog(
        barrierDismissible: dismissible ?? false,
        context: Get.context!,
        builder: (context) => const LoadingDialog());
  }

  static void hide() => Get.back();
}

//---------------<Custom Dialog>-----------------
enum TypeDialog {
  FAILED,
  SUCCESS,
  WARNING,
  RETRY,
  SOON,
  PERMISSION,
}

class AppDialog {
  static show({
    required String message,
    required VoidCallback onPress,
    required TypeDialog typeDialog,
    String? title,

    VoidCallback? onCancel,
    bool? dismissible,
    String? confirmText,
    Widget? header,
    Color? backgroundColorHeader = Colors.transparent,
  }) {
    switch (typeDialog) {
      case TypeDialog.FAILED:
        return showDialog(
          barrierDismissible: dismissible ?? true,
          context: Get.context!,
          builder: (context) => DialogAlert.error(
            title: title ?? International.failed.tr,
            description: message,
            onConfirm: onPress,
          ),
        );
      case TypeDialog.SUCCESS:
        return showDialog(
          barrierDismissible: dismissible ?? false,
          context: Get.context!,
          builder: (context) => DialogAlert.success(
            title: title ?? International.success.tr,
            description: message,
            onConfirm: onPress,
          ),
        );
      case TypeDialog.WARNING:
        return showDialog(
          barrierDismissible: dismissible ?? true,
          context: Get.context!,
          builder: (context) => DialogAlert.warning(
            title: title ?? International.warning.tr,
            backgroundColorHeader: Colors.orange,
            description: message,
            onConfirm: onPress,
            onCancel: onCancel ?? () => Get.back(),
          ),
        );
      case TypeDialog.SOON:
        return showDialog(
          barrierDismissible: dismissible ?? true,
          context: Get.context!,
          builder: (context) => const SoonDialog(),
        );
      case TypeDialog.RETRY:
        return showDialog(
          barrierDismissible: dismissible ?? true,
          context: Get.context!,
          builder: (context) => DialogAlert.retry(
            title: title ?? International.failed.tr,
            description: message,
            onConfirm: onPress,
            onCancel: onCancel ?? () => Get.back(),
          ),
        );
      case TypeDialog.PERMISSION:
        return showDialog(
          barrierDismissible: false,
          context: Get.context!,
          builder: (context) => DialogAlert.permission(
            header: header,
            backgroundColorHeader: Colors.orange,
            title: title ?? International.warning.tr,
            description: message,
            onConfirm: onPress,
            onCancel: onCancel ?? () => Get.back(),
            confirmText: confirmText ?? 'OK',
          ),
        );
    }
  }

  static close() => Get.back();
}