import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

import 'app_colors.dart';

class AppStyle {
  static final baseTextStyle = GoogleFonts.mulish();

  static TextStyle title40 = baseTextStyle.copyWith(fontSize: 40, color: AppColors.systemBlack);
  static TextStyle title34 = baseTextStyle.copyWith(fontSize: 34, color: AppColors.systemBlack);
  static TextStyle title30 = baseTextStyle.copyWith(fontSize: 30, color: AppColors.systemBlack);
  static TextStyle title28 = baseTextStyle.copyWith(fontSize: 28, color: AppColors.systemBlack);

  static TextStyle subtitle24 = baseTextStyle.copyWith(fontSize: 24, color: AppColors.systemBlack);
  static TextStyle subtitle20 = baseTextStyle.copyWith(fontSize: 20, color: AppColors.systemBlack);
  static TextStyle subtitle18 = baseTextStyle.copyWith(fontSize: 18, color: AppColors.systemBlack);
  static TextStyle subtitle16 = baseTextStyle.copyWith(fontSize: 16, color: AppColors.systemBlack);

  static TextStyle subtitle14 = baseTextStyle.copyWith(fontSize: 14, color: AppColors.systemBlack);
  static TextStyle normalSmall = baseTextStyle.copyWith(fontSize: 12, color: AppColors.systemBlack);
  static TextStyle superSmall = baseTextStyle.copyWith(fontSize: 8, color: AppColors.systemBlack);

  static TextStyle headline1 = baseTextStyle.copyWith(
      fontSize: 34, fontWeight: FontWeight.w800, color: AppColors.primary);
  static TextStyle headline2 = baseTextStyle.copyWith(
      fontSize: 26, fontWeight: FontWeight.w800, color: AppColors.primary);
  static TextStyle headline3 = baseTextStyle.copyWith(
      fontSize: 20, fontWeight: FontWeight.w700, color: AppColors.primary);
  static TextStyle headline4 = baseTextStyle.copyWith(
      fontSize: 16, fontWeight: FontWeight.w700, color: AppColors.primary);

  static TextStyle link =
      baseTextStyle.copyWith(fontSize: 18, color: Colors.blue);

  // Font Weight
  static FontWeight superBold = FontWeight.w600;
  static FontWeight semiBold = FontWeight.w600;
  static FontWeight mediumWeight = FontWeight.w500;
  static FontWeight regularWeight = FontWeight.w400;
}
