import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../ui/widgets/colored_status_bar.dart';
import '../themes/app_colors.dart';

/// ViewInterface
mixin ViewInterface {
  /// buildBody
  Widget buildBody(BuildContext context);

  /// buildAppBar
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    return null;
  }

  /// buildBottomNavigationBar
  Widget? buildBottomNavigationBar(BuildContext context) {
    return null;
  }

  /// buildBottomSheet
  Widget? buildBottomSheet(BuildContext context) {
    return null;
  }

  /// buildDrawer
  Widget? buildDrawer(BuildContext context) {
    return null;
  }

  /// buildEndDrawer
  Widget? buildEndDrawer(BuildContext context) {
    return null;
  }

  /// buildFloatActionButton
  Widget? buildFloatActionButton(BuildContext context) {
    return null;
  }

  /// clearFocus
  void clearFocus(BuildContext context) {
    if (FocusScope.of(context).hasFocus) {
      FocusScope.of(context).unfocus();
    } else {
      FocusScope.of(context).requestFocus(FocusNode());
    }
  }

  /// getTextFieldDecor
  InputDecoration getTextFieldDecor(
      {String? hint, String? label, String? helperText, Widget? suffixIcon}) {
    return InputDecoration(
      labelText: label,
      hintText: hint,
      helperText: helperText,
      suffixIcon: suffixIcon,
      hintStyle: const TextStyle(color: Color(0xFFE5E5E5), fontSize: 14),
      border: const UnderlineInputBorder(
        borderSide: BorderSide(color: const Color(0xFFE5E5E5)),
      ),
      enabledBorder: const UnderlineInputBorder(
        borderSide: BorderSide(color: Color(0xFFE5E5E5)),
      ),
    );
  }

  /// buildPage
  Widget buildPage(BuildContext context) {
    return ColoredStatusBar(
      child: Scaffold(
        backgroundColor: AppColors.white,
        resizeToAvoidBottomInset: false,
        appBar: buildAppBar(context),
        body: buildBody(context),
        bottomNavigationBar: buildBottomNavigationBar(context),
        bottomSheet: buildBottomSheet(context),
        drawer: buildDrawer(context),
        endDrawer: buildEndDrawer(context),
        floatingActionButton: buildFloatActionButton(context),
      ),
    );
  }
}
