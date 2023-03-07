import 'dart:collection';

import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'package:get/get.dart';
import '../../../../core/base/stateless_view_base.dart';
import '../../../../core/localization/languages/vietnam.dart';
import '../../../widgets/base/base_appbar.dart';
import '../../../widgets/base/base_view.dart';
import '../payment_success.dart';
import 'vnpay_controller.dart';

class VNPayView extends StateLessViewBase<VNPayController> {
  static const routeName = '/vnpay_payment';

  InAppWebViewController? webViewController;
  InAppWebViewGroupOptions options = InAppWebViewGroupOptions(
      crossPlatform: InAppWebViewOptions(
        useShouldOverrideUrlLoading: true,
        supportZoom: false,
        mediaPlaybackRequiresUserGesture: false,
      ),
      android: AndroidInAppWebViewOptions(
        useHybridComposition: true,
      ),
      ios: IOSInAppWebViewOptions(
        allowsInlineMediaPlayback: true,
        maximumZoomScale: 1,
        minimumZoomScale: 1,
      ));

  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return Obx(
      () => BaseView(
        loadingEnabled: viewModel.isLoading.value,
        errorEnabled: viewModel.isError.value,
        onRetry: viewModel.onInit,
        child: Stack(
          children: [
            SizedBox(
              height: MediaQuery.of(context).size.height * 3,
              child: InAppWebView(
                // contextMenu: contextMenu,
                initialUrlRequest:
                    URLRequest(url: Uri.parse(viewModel.paymentUrl)),
                // initialFile: "assets/index.html",
                initialUserScripts: UnmodifiableListView<UserScript>([]),
                initialOptions: options,
                onWebViewCreated: (controller) {
                  webViewController = controller;
                },
                androidOnPermissionRequest:
                    (controller, origin, resources) async {
                  return PermissionRequestResponse(
                      resources: resources,
                      action: PermissionRequestResponseAction.GRANT);
                },
                shouldOverrideUrlLoading: (controller, navigationAction) async {
                  print('nav : ${navigationAction.request.url.toString()}');
                  // if (navigationAction.request.url
                  //         .toString()
                  //         .contains('1000354200174') &&
                  //     !navigationAction.request.url
                  //         .toString()
                  //         .contains('vnp_ReturnUrl')) {
                  //   // await controller.stopLoading();
                  //   // viewModel.confirmOrder();
                  //   await Get.toNamed(PaymentSuccess.routeName);
                  // }

                  return NavigationActionPolicy.ALLOW;
                },
              ),
            )
          ],
        ),
        isConnectNetwork: viewModel.isConnectNetwork.value,
      ),
    );
  }

  @override
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    // TODO: implement buildAppBar
    return AppBarTitle(title: 'Thanh toán');
  }
}
