import 'dart:async';
import 'package:connectivity_plus/connectivity_plus.dart';
import 'package:get/get.dart';
import 'package:logger/logger.dart';

abstract class BaseController extends GetxController {
  RxBool isLoading = false.obs;
  RxString errorMessage = ''.obs;
  RxBool isError = false.obs;
  RxBool isConnectNetwork = true.obs;

  /// subscription
  late StreamSubscription<ConnectivityResult> subscription;

  /// logger
  final logger = Logger();
  @override
  void onInit() {
    // TODO: implement onInit
    super.onInit();
    listenConnectivityStatus();
  }

  /// listenConnectivityStatus
  void listenConnectivityStatus() {
    subscription =
        Connectivity().onConnectivityChanged.listen(_updateConnectionStatus);
  }

  /// cancelConnectivitySubscription
  void cancelConnectivitySubscription() {
    subscription.cancel();
  }

  Future<void> _updateConnectionStatus(ConnectivityResult result) async {
    switch (result) {
      case ConnectivityResult.wifi:
        onConnected();
        logger.d('ConnectivityResult.wifi');
        break;

      case ConnectivityResult.mobile:
        logger.d('ConnectivityResult.mobile');
        onConnected();
        break;

      case ConnectivityResult.none:
        logger.e('ConnectivityResult.none');
        onDisconnect();
        break;
      case ConnectivityResult.bluetooth:
      // TODO: Handle this case.
        break;
      case ConnectivityResult.ethernet:
      // TODO: Handle this case.
        break;
      case ConnectivityResult.vpn:
        // TODO: Handle this case.
        break;
    }
  }

  /// onInitView
  void onInitView() {}

  /// onDisposeView
  void onDisposeView() {}

  /// onConnected
  void onConnected() {
    isConnectNetwork(true);
  }

  /// onDisconnect
  void onDisconnect() {
    isConnectNetwork(true);
  }

  void showLoading() {
    isLoading.toggle();
    isError.value = false;
    errorMessage.value = '';
  }
  Rx<bool> hideLoading() => isLoading.toggle();

  void showError(String message) {
    errorMessage.value = message;
    isError.value = true;
  }
}