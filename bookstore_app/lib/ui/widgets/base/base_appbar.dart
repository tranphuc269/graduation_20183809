import 'package:flutter/material.dart';

import '../../../core/themes/app_colors.dart';
import '../../../core/themes/app_style.dart';
import '../back_widget.dart';

class BaseAppBar extends StatelessWidget implements PreferredSizeWidget {
  const BaseAppBar({
    Key? key,
    this.title,
    this.action,
    this.backgroundColor,
    this.centerTitle = false,
    this.titleStyle,
    this.iconColor,
    this.elevation,
    this.height,
  }) : super(key: key);

  final String? title;
  final Color? backgroundColor;
  final List<Widget>? action;
  final bool? centerTitle;
  final Color? iconColor;
  final TextStyle? titleStyle;
  final double? elevation;
  final double? height;

  @override
  Widget build(BuildContext context) {
    return AppBar(
      centerTitle: centerTitle,
      title: Text(
        title ?? '',
        style: titleStyle,
      ),
      backgroundColor: backgroundColor,
      elevation: elevation,
      actions: action,
      iconTheme: IconThemeData(color: iconColor),
    );
  }

  @override
  Size get preferredSize => Size.fromHeight(height ?? kToolbarHeight);
}

class AppBarTitle extends AppBar {
  AppBarTitle({required String title})
      : super(
          leading: const BackWidget(),
          backgroundColor: AppColors.white,
          elevation: 0.5,
          title: Text(
            title,
            style: AppStyle.subtitle20.copyWith(color: AppColors.systemBlack),
          ),
        );
}
