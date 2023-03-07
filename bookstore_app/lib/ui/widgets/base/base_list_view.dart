import 'package:flutter/material.dart';

import '../list_pagination/error_view.dart';
import '../list_pagination/list_empty_view.dart';
import '../shimmer_list.dart';

class BaseListView extends StatelessWidget {
  const BaseListView({
    required this.emptyEnabled,
    required this.loadingEnabled,
    required this.errorEnabled,
    required this.onRetry,
    required this.child,
    Key? key,
    this.emptyImage,
    this.emptyTitle,
    this.emptySubtitle,
    this.loadingView,
    this.visibleOnEmpty = true,
    this.visibleOnError = true,
    this.errorImage,
    this.errorSubtitle,
    this.errorTitle,
    this.isComponent = true,
    this.emptyView,
    this.retryText,
  }) : super(key: key);

  /// Can override setting Visibility emptyView even if [emptyEnabled] is true
  final bool visibleOnEmpty;

  /// Can override setting Visibility emptyView even if [errorEnabled] is true
  final bool visibleOnError;

  /// Show [loadingView] when set to *true*
  final bool loadingEnabled;

  /// Show [emptyView] when set to *true*
  final bool emptyEnabled;

  /// Show [errorView] when set to *true*
  final bool errorEnabled;

  /// Loading view that will show if [loadingEnabled] is true
  final Widget? loadingView;

  /// Image that will show if [emptyEnabled] is true
  final Widget? emptyImage;

  /// Title that will show if [emptyEnabled] is true
  final String? emptyTitle;

  /// Subtitle that will show if [emptyEnabled] is true
  final String? emptySubtitle;

  /// Image that will show if [errorEnabled] is true
  final Widget? errorImage;

  /// Title that will show if [errorEnabled] is true
  final String? errorTitle;

  /// Subtitle that will show if [errorEnabled] is true
  final String? errorSubtitle;

  /// Set scrollable of your empty/error view
  final bool isComponent;

  final String? retryText;

  /// Function to controll onPress 'retry' if [errorEnabled] is true
  final void Function()? onRetry;

  final Widget? emptyView;

  final Widget child;

  @override
  Widget build(BuildContext context) {
    final loadingWidget = loadingView ?? const ShimmerList();

    return Stack(
      children: [
        getBodyWidget(),
        getErrorView(),
        getEmptyView(),
        getLoadingView(loadingWidget),
      ],
    );
  }

  Widget getBodyWidget() =>
      loadingEnabled || emptyEnabled || errorEnabled ? Container() : child;

  Widget getLoadingView(Widget loadingWidget) => loadingEnabled
      ? Center(
          child: AnimatedOpacity(
            opacity: loadingEnabled ? 1.0 : 0.0,
            duration: const Duration(milliseconds: 200),
            child: loadingWidget,
          ),
        )
      : Container();

  Widget getEmptyView() =>
      visibleOnEmpty && emptyEnabled && !errorEnabled && !loadingEnabled
          ? emptyView ??
              ListEmptyView(
                emptyImage: emptyImage,
                emptyTitle: emptyTitle,
                emptySubtitle: emptySubtitle,
                isScrollable: isComponent,
              )
          : Container();

  Widget getErrorView() => visibleOnError && errorEnabled
      ? ErrorView(
          errorImage: errorImage,
          errorTitle: errorTitle,
          errorSubtitle: errorSubtitle,
          onRetry: onRetry,
          retryText: retryText,
          isScrollable: isComponent,
        )
      : Container();
}
