import 'package:get/get.dart';

import '../database/get_storage/get_storage_key.dart';
import '../database/get_storage/get_storage_manager.dart';

class ThemeManager extends GetxController {
  static ThemeManager get find => Get.find<ThemeManager>();

  /// Default value of app theme is Light.
  /// So this variable have default value = false
  RxBool isDark = false.obs;
  bool toDarkMode() => isDark.value = true;
  bool toLightMode() => isDark.value = false;

  @override
  Future<void> onReady() async {
    isDark.value = await GetStorageManager.find.getAwait(GetStorageKey.DARK_THEME) ?? false;
    super.onReady();
  }

  /// Default value of theme is Light.
  /// So, if you want use [changeTheme] it will change theme to Dark.
  /// And continuous repeat switching between Dark and Light.
  Future<Rx<bool>> changeTheme() async {
    if (isDark.isTrue) {
      GetStorageManager.find.save(GetStorageKey.DARK_THEME, false);
    } else {
      GetStorageManager.find.save(GetStorageKey.DARK_THEME, true);
    }
    return isDark.toggle();
  }
}