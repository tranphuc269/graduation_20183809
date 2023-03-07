import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:get/get.dart';
import 'package:get_storage/get_storage.dart';
import 'package:intl/date_symbol_data_local.dart';

import 'core/app/app_env.dart';
import 'core/app/app_info.dart';
import 'core/app/app_socket.dart';
import 'core/auth_manager/auth_manager.dart';
import 'core/database/get_storage/get_storage_manager.dart';
import 'core/database/hive/hive_db.dart';
import 'core/database/secure_storage/secure_storage_manager.dart';
import 'core/helper/general_function.dart';
import 'core/network/api_config.dart';
import 'core/themes/app_theme.dart';
import 'core/themes/theme_manager.dart';
import 'data/sources/server/catalog/category/category_service_impl.dart';
import 'data/sources/server/catalog/producer/producer_service_impl.dart';
import 'data/sources/server/catalog/product/product_service_impl.dart';
import 'data/sources/server/notification/notification_service_impl.dart';
import 'data/sources/server/order/cart/cart_service_impl.dart';
import 'data/sources/server/order/order/order_service_impl.dart';

class Initializer extends GetxService {
  static Future<void> init() async {
    HttpOverrides.global = MyHttpOverrides();
    await _initConfig();
    await _initService();
    AppStatusBar.set(brightness: Brightness.light);
  }

  static Future<void> _initConfig() async {
    // Database
    // * [Be Careful] Writing order can affects the algorithm
    await HiveDb.init();
    await GetStorage.init();
    await Get.putAsync(() async => GetStorage());
    Get.put(const FlutterSecureStorage(), permanent: true);

    // Configuration
    // ---Locale
    await initializeDateFormatting('id_ID', null);
    // --- Package Info
    Get.lazyPut(() => AppInfo());
    // --- App Config
    Get.lazyPut(() => AppEnv());
    // --- Web Socket
    Get.lazyPut(() => AppSocket());
    // --- Request Client
    Get.lazyPut(() => DioClient());
  }

  static Future<void> _initService() async {
    // Initialize Apps and checking user auth
    Get.lazyPut(() => GetStorageManager(), fenix: true);
    Get.lazyPut(() => SecureStorageManager(), fenix: true);
    Get.put(ThemeManager(), permanent: true);

    // Checking user auth
    Get.put(AuthManager(), permanent: true);

    // api service
    Get.lazyPut(() => CategoryServiceImpl(), fenix: true);
    Get.lazyPut(() => OrderServiceImpl(), fenix: true);
    Get.lazyPut(() => ProducerServiceImpl(), fenix: true);
    Get.lazyPut(() => ProductServiceImpl(), fenix: true);
    Get.lazyPut(() => CartServiceImpl(), fenix: true);
    Get.lazyPut(() => NotificationServiceImpl(), fenix: true);
  }
}
