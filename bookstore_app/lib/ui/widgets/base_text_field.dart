import 'package:flutter/material.dart';

import '../../core/themes/app_style.dart';

InputDecoration getInputDecorationCommon(BuildContext context,
    {Color? fillColor, Color? borderSideColor}) {
  return InputDecoration(
    filled: true,
    enabledBorder: OutlineInputBorder(
        borderSide:
            BorderSide(color: borderSideColor ?? const Color(0xFFF6F8FE)),
        borderRadius: BorderRadius.circular(20),
        gapPadding: 1),
    border: OutlineInputBorder(
        borderSide: const BorderSide(color: Color(0xFFF6F8FE)),
        borderRadius: BorderRadius.circular(20)),
    fillColor: fillColor ?? const Color(0xFFF6F8FE),
    contentPadding: const EdgeInsets.only(left: 16, top: 16),
  );
}

TextStyle getInputTextStyle() {
  return AppStyle.subtitle16;
}
