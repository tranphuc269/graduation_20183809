import 'package:get/get.dart';

import '../../app_configuration.dart';
import '../network/api_token_manager.dart';
import 'app_socket.dart';

enum Env {
  PRODUCTION,
  STAGING,
  DEVELOPMENT,
}

class AppEnv {
  static AppEnv get find => Get.find<AppEnv>();

  late Config appConfig;
  Config get get => appConfig;
  set setEnv(Config config) => appConfig = config;

  static set(Env env) {
    switch (env) {
      case Env.PRODUCTION:
        AppEnv.find.setEnv = Config(
          baseUrl: AppConfiguration.productionAPI,
          clientToken: AppConfiguration.clientToken,
          tokenType: AppConfiguration.tokenType,
          socketUrl: AppConfiguration.productionSocket,
          midtransClientKey: AppConfiguration.midtransStagingKey,
        );
        break;
      case Env.STAGING:
        AppEnv.find.setEnv = Config(
          baseUrl: AppConfiguration.developmentAPI,
          clientToken: AppConfiguration.clientToken,
          tokenType: AppConfiguration.tokenType,
          socketUrl: AppConfiguration.stagingSocket,
          midtransClientKey: AppConfiguration.midtransStagingKey,
        );
        break;
      case Env.DEVELOPMENT:
        AppEnv.find.setEnv = Config(
          baseUrl: AppConfiguration.developmentAPI,
          clientToken: AppConfiguration.clientToken,
          tokenType: AppConfiguration.tokenType,
          socketUrl: AppConfiguration.developmentSocket,
          midtransClientKey: AppConfiguration.midtransStagingKey,
        );
        AppSocket().interceptor();
        break;
    }
  }
}

class Config {
  Config({
    required this.baseUrl,
    required this.clientToken,
    required this.tokenType,
    required this.midtransClientKey,
    required this.socketUrl,
  });
  String baseUrl;
  String clientToken;
  TokenType tokenType;
  String socketUrl;
  String midtransClientKey;
}