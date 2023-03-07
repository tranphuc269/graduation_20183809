import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:get/route_manager.dart';
import 'package:lottie/lottie.dart';

import '../../core/themes/app_colors.dart';
import '../../core/themes/app_style.dart';
import 'base_button.dart';

class BaseDialog extends StatelessWidget {
  const BaseDialog({
    required this.child,
    Key? key,
  }) : super(key: key);
  final Widget child;

  @override
  Widget build(BuildContext context) {
    return Dialog(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
      elevation: 0,
      backgroundColor: Colors.transparent,
      child: Stack(
        children: [
          Wrap(
            children: [
              Container(
                padding: const EdgeInsets.fromLTRB(16, 100, 16, 16),
                margin: const EdgeInsets.only(top: 16),
                decoration: BoxDecoration(
                  color: (Get.isDarkMode) ? Colors.black : Colors.white,
                  shape: BoxShape.rectangle,
                  borderRadius: BorderRadius.circular(17),
                  boxShadow: [
                    BoxShadow(
                        color:
                            (Get.isDarkMode) ? AppColors.primary : Colors.black,
                        offset: const Offset(0, 0),
                        blurRadius: 10)
                  ],
                ),
                child: child,
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class LoadingDialog extends StatelessWidget {
  const LoadingDialog({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Dialog(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
      elevation: 0,
      backgroundColor: Colors.transparent,
      child: Container(
        height: 80,
        margin: const EdgeInsets.all(24),
        width: MediaQuery.of(context).size.width,
        decoration: BoxDecoration(
          color: Colors.black,
          shape: BoxShape.rectangle,
          borderRadius: BorderRadius.circular(17),
          boxShadow: [
            BoxShadow(
                color: (Get.isDarkMode) ? AppColors.primary : Colors.black26,
                offset: const Offset(0, 2),
                blurRadius: 10)
          ],
        ),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Đang tải',
              style: AppStyle.subtitle18.copyWith(color: Colors.white),
            ),
            const SizedBox(width: 4),
            const SpinKitThreeBounce(color: Colors.white, size: 16),
          ],
        ),
      ),
    );
  }
}

class DialogAlert extends StatelessWidget {
  const DialogAlert({
    required this.title,
    required this.description,
    required this.header,
    required this.onConfirm,
    required this.backgroundColorHeader,
    Key? key,
    this.onCancel,
    this.confirmColor = AppColors.primary,
    this.cancelColor = AppColors.primary,
    this.confirmText = 'Ya',
    this.confirmTextColor,
    this.confirmBorderColor,
    this.confirmBackgroundColor,
  }) : super(key: key);

  factory DialogAlert.success({
    required String title,
    required String description,
    required VoidCallback onConfirm,
    Widget? header,
    Color? backgroundColorHeader,
  }) =>
      DialogAlert(
        title: title,
        description: description,
        header: header ??
            Lottie.asset('assets/anim/anim_success.json', repeat: false),
        onConfirm: onConfirm,
        backgroundColorHeader: backgroundColorHeader ?? Colors.green[50],
        confirmTextColor: Colors.white,
        confirmBorderColor: Colors.green,
        confirmBackgroundColor: Colors.green,
      );

  factory DialogAlert.error({
    required String title,
    required String description,
    required VoidCallback onConfirm,
    Widget? header,
    Color? backgroundColorHeader,
  }) =>
      DialogAlert(
        title: title,
        description: description,
        header: header ??
            Lottie.asset('assets/anim/anim_failed.json', repeat: false),
        onConfirm: onConfirm,
        backgroundColorHeader: backgroundColorHeader ?? Colors.red[100],
        confirmTextColor: Colors.white,
        confirmBorderColor: AppColors.primaryVariant,
        confirmBackgroundColor: AppColors.primaryVariant,
      );

  factory DialogAlert.warning({
    required String title,
    required String description,
    required VoidCallback onConfirm,
    required VoidCallback onCancel,
    Widget? header,
    Color? backgroundColorHeader,
  }) =>
      DialogAlert(
        title: title,
        description: description,
        header: header ??
            Lottie.asset('assets/anim/anim_warning.json', repeat: false),
        onConfirm: onConfirm,
        onCancel: onCancel,
        backgroundColorHeader: backgroundColorHeader ?? Colors.orangeAccent,
      );

  factory DialogAlert.retry({
    required String title,
    required String description,
    required VoidCallback onConfirm,
    required VoidCallback onCancel,
    String confirmText = 'Coba Lagi',
    Widget? header,
    Color? backgroundColorHeader,
  }) =>
      DialogAlert(
        title: title,
        description: description,
        confirmText: confirmText,
        header: header ??
            Lottie.asset('assets/anim/anim_failed.json', repeat: false),
        onConfirm: onConfirm,
        onCancel: onCancel,
        confirmColor: AppColors.primary,
        backgroundColorHeader: backgroundColorHeader ?? Colors.red[100],
      );

  factory DialogAlert.permission({
    required String title,
    required String confirmText,
    required String description,
    required VoidCallback onConfirm,
    required void Function() onCancel,
    Color? backgroundColorHeader,
    Widget? header,
  }) =>
      DialogAlert(
        title: title,
        description: description,
        header: header ??
            Lottie.asset('assets/anim/anim_warning.json', repeat: false),
        onConfirm: onConfirm,
        confirmText: confirmText,
        backgroundColorHeader: backgroundColorHeader ?? Colors.orangeAccent,
        confirmColor: Colors.blue,
      );
  final String title, description, confirmText;
  final VoidCallback? onConfirm, onCancel;
  final Color confirmColor, cancelColor;
  final Widget? header;
  final Color? backgroundColorHeader;
  final Color? confirmTextColor, confirmBorderColor, confirmBackgroundColor;

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      onWillPop: () async => false,
      child: Dialog(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
        elevation: 0,
        backgroundColor: Colors.transparent,
        child: Stack(
          children: [
            Wrap(
              children: [
                Container(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 16, vertical: 32),
                  margin: const EdgeInsets.only(top: 26),
                  decoration: BoxDecoration(
                      color: (Get.isDarkMode) ? Colors.black : Colors.white,
                      shape: BoxShape.rectangle,
                      borderRadius: BorderRadius.circular(17),
                      boxShadow: [
                        BoxShadow(
                            color: (Get.isDarkMode)
                                ? AppColors.primary
                                : Colors.black,
                            offset: const Offset(0, 0),
                            blurRadius: 10)
                      ]),
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      const SizedBox(height: 64),
                      Text(
                        title,
                        style: AppStyle.subtitle18.copyWith(
                          fontWeight: AppStyle.semiBold,
                        ),
                      ),
                      const SizedBox(height: 4),
                      Text(
                        description,
                        textAlign: TextAlign.center,
                        style: const TextStyle(color: Colors.grey),
                      ),
                      const SizedBox(height: 32),
                      BaseButton(
                        text: confirmText,
                        textColor: confirmTextColor ?? AppColors.primary,
                        color: confirmBackgroundColor ?? Colors.white,
                        onPressed: onConfirm,
                        borderColor: confirmBorderColor ?? AppColors.primary,
                        fontWeight: AppStyle.semiBold,
                      ),
                      const SizedBox(height: 8),
                      Visibility(
                        visible: onCancel != null,
                        child: BaseButton(
                          text: 'Tidak',
                          fontWeight: AppStyle.semiBold,
                          color: cancelColor,
                          onPressed: onCancel,
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
            Positioned(
              top: 0,
              left: 16,
              right: 16,
              child: CircleAvatar(
                backgroundColor: backgroundColorHeader,
                radius: 50,
                child: header,
              ),
            )
          ],
        ),
      ),
    );
  }
}

class SoonDialog extends StatelessWidget {
  const SoonDialog({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BaseDialog(
      child: Column(
        children: [
          SizedBox(
            height: 250,
            width: 200,
            child: Lottie.asset('assets/anim/anim_soon.json'),
          ),
          Text(
            'COMING SOON',
            style: AppStyle.headline2,
          ),
          Text(
            'Fitur ini lagi dikembangin..',
            style: AppStyle.subtitle16,
            textAlign: TextAlign.center,
          ),
          const SizedBox(height: 24),
          Align(
            alignment: Alignment.bottomRight,
            child: BaseButton(
              onPressed: () => Get.back(),
              text: 'OK',
              color: AppColors.primary,
            ),
          )
        ],
      ),
    );
  }
}
