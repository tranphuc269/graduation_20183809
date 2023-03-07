import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../auto_hiden_keyboard.dart';
import '../list_pagination/error_view.dart';
import '../no_internet_widget.dart';
import '../shimmer_detail.dart';

class BaseView extends StatelessWidget {
  const BaseView({
    required this.loadingEnabled,
    required this.errorEnabled,
    required this.onRetry,
    required this.child,
    required this.isConnectNetwork,
    Key? key,
    this.loadingView,
    this.errorView,
    this.errorMsg,
  }) : super(key: key);

  final bool loadingEnabled;
  final bool errorEnabled;
  final bool isConnectNetwork;
  final Widget? loadingView;
  final Widget? errorView;
  final Widget child;
  final String? errorMsg;
  final VoidCallback onRetry;

  @override
  Widget build(BuildContext context) {
    return AutoHideKeyboard(
      child: RefreshIndicator(
        onRefresh: () => Future.sync(onRetry),
        child: SingleChildScrollView(
          child: isConnectNetwork
              ? (loadingEnabled
                  ? loadingView ?? const ShimmerDetail()
                  : errorEnabled
                      ? errorView ??
                          ErrorView(
                            isScrollable: false,
                            errorSubtitle: errorMsg,
                            onRetry: onRetry,
                          )
                      : child)
              : NoInternetWidget(
                  onPress: () => Future.sync(onRetry),
                ),
        ),
      ),
    );
  }
}
