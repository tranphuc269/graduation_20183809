import 'package:flutter/material.dart';
import 'package:infinite_scroll_pagination/infinite_scroll_pagination.dart';

import '../list_pagination/list_empty_view.dart';
import '../list_pagination/pagination_error_load_view.dart';
import '../shimmer_list.dart';

typedef ItemWidgetBuilder<ItemType> = Widget Function(
  BuildContext context,
  ItemType item,
  int index,
);

class BasePaginationView<ItemType> extends StatelessWidget {
  const BasePaginationView({
    required this.pagingController,
    required this.itemBuilder,
    required this.onRefresh,
    Key? key,
    this.loadingView,
    this.emptyView,
    this.errorView,
    this.errorLoadView,
    this.maxItemView,
    this.emptyImage,
    this.emptyTitle,
    this.emptySubtitle,
  }) : super(key: key);

  final PagingController<int, ItemType> pagingController;

  // final ItemWidgetBuilder
  final ItemWidgetBuilder<ItemType> itemBuilder;

  final Widget? loadingView;

  /// ** Empty View **
  /// View when data list is empty
  final Widget? emptyView;

  /// ** Error View **
  /// View when all item already loaded
  final Widget? maxItemView;

  /// ** Max Item Indicator/View **
  /// View when initial/first load error
  final Widget? errorView;

  /// ** Error load  ** .
  /// View when load pagination error
  final Widget? errorLoadView;

  final VoidCallback onRefresh;

  final Widget? emptyImage;

  final String? emptyTitle;

  final String? emptySubtitle;

  @override
  Widget build(BuildContext context) {
    return RefreshIndicator(
      onRefresh: () => Future.sync(onRefresh),
      child: PagedListView<int, ItemType>(
        pagingController: pagingController,
        builderDelegate: PagedChildBuilderDelegate<ItemType>(
          animateTransitions: true,
          firstPageProgressIndicatorBuilder: (ctx) =>
              loadingView ?? const ShimmerList(),
          noItemsFoundIndicatorBuilder: (ctx) =>
              emptyView ??
              ListEmptyView(
                emptyImage: emptyImage,
                emptyTitle: emptyTitle,
                emptySubtitle: emptySubtitle,
              ),
          // firstPageErrorIndicatorBuilder: (ctx) =>
          //     errorView ?? PaginationErrorView(controller: pagingController),
          // noMoreItemsIndicatorBuilder: (ctx) =>
          // maxItemView ?? const PaginationMaxItemView(),
          newPageErrorIndicatorBuilder: (ctx) =>
              errorLoadView ?? const PaginationErrorLoadView(),
          itemBuilder: itemBuilder,
        ),
      ),
    );
  }
}
