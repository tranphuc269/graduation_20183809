import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'app_colors.dart';

final ThemeData lightTheme = ThemeData(
  primaryColor: AppColors.materialPrimary,
  primarySwatch: AppColors.materialPrimary,
  indicatorColor: AppColors.accent,
  fontFamily: 'Poppins',
  brightness: Brightness.light,
  bottomSheetTheme: const BottomSheetThemeData(
    elevation: 8,
    backgroundColor: Color(0xFFf4eee4),
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.only(
        topLeft: Radius.circular(20),
        topRight: Radius.circular(20),
      ),
    ),
  ),
  appBarTheme: const AppBarTheme(
    systemOverlayStyle: SystemUiOverlayStyle(
      statusBarBrightness: Brightness.light,
      systemNavigationBarColor: Colors.black,
      statusBarColor: AppColors.primary,
    ),
  ),
);

final ThemeData darkTheme = ThemeData(
  primaryColor: AppColors.materialPrimary,
  primarySwatch: AppColors.materialPrimary,
  indicatorColor: AppColors.accent,
  fontFamily: 'Poppins',
  brightness: Brightness.dark,
  bottomSheetTheme: const BottomSheetThemeData(
    elevation: 8,
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.only(
        topLeft: Radius.circular(24),
        topRight: Radius.circular(24),
      ),
    ),
  ),
  appBarTheme: const AppBarTheme(
    systemOverlayStyle: SystemUiOverlayStyle(
      statusBarBrightness: Brightness.light,
      systemNavigationBarColor: Colors.black,
      statusBarColor: AppColors.primary,
    ),
  ),
);

extension DarkMode on BuildContext {
  bool isDarkMode() {
    final brightness = MediaQuery.of(this).platformBrightness;
    return brightness == Brightness.dark;
  }
}

class AppStatusBar {
  static void set({
    required Brightness brightness,
    Color color = AppColors.primary,
  }) {
    Brightness _iconBrightness;
    if (Platform.isIOS) {
      (brightness == Brightness.dark)
          ? _iconBrightness = Brightness.light
          : _iconBrightness = Brightness.dark;
    } else {
      _iconBrightness = brightness;
    }
    return SystemChrome.setSystemUIOverlayStyle(
      SystemUiOverlayStyle(
        statusBarBrightness: _iconBrightness,
        statusBarColor: color,
      ),
    );
  }
}

class AppOrientation {
  static Future<void> lock(DeviceOrientation orientation) {
    return SystemChrome.setPreferredOrientations([
      orientation,
    ]);
  }
}