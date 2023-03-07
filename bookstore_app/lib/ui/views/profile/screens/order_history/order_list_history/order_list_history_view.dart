import 'package:bubble_tab_indicator/bubble_tab_indicator.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../../../../core/app/app_constant.dart';
import '../../../../../../core/base/stateless_view_base.dart';
import '../../../../../../core/themes/app_colors.dart';
import '../../../../../widgets/base/base_appbar.dart';
import '../../../../../widgets/base/base_view.dart';
import '../../../../../widgets/order.dart';
import 'order_list_history_controller.dart';

class OrderListHistoryView
    extends StateLessViewBase<OrderListHistoryController> {
  static const routeName = '/order_list_history';
  final List<Widget> tabs = <Widget>[
    const Padding(
      padding: EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: Tab(text: 'Hoàn thành'),
    ),
    const Padding(
      padding: EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: Tab(text: 'Xử lý'),
    ),
    const Padding(
      padding: EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: Tab(text: 'Huỷ'),
    ),
  ];

  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return DefaultTabController(
      length: tabs.length,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Container(
            padding: const EdgeInsets.symmetric(
                horizontal: AppConst.defaultVerySmallMargin),
            child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: <Widget>[
                  const Padding(padding: EdgeInsets.only(bottom: kFixPadding)),
                  TabBar(
                    indicatorSize: TabBarIndicatorSize.tab,
                    labelColor: AppColors.white,
                    labelPadding: const EdgeInsets.symmetric(horizontal: 0),
                    unselectedLabelColor: kDarkColor,
                    indicator: const BubbleTabIndicator(
                      indicatorHeight: 32,
                      indicatorColor: Colors.black,
                      tabBarIndicatorSize: TabBarIndicatorSize.tab,
                    ),
                    tabs: tabs,
                    unselectedLabelStyle: const TextStyle(fontSize: 16),
                    labelStyle: const TextStyle(fontSize: 16)
                        .copyWith(color: AppColors.white),
                  ),
                ]),
          ),
          const Padding(padding: EdgeInsets.only(bottom: kFixPadding)),
          Expanded(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: kFixPadding),
              child: TabBarView(
                children: <Widget>[
                  Obx(() => BaseView(
                      loadingEnabled: viewModel.isLoading.value,
                      errorEnabled: viewModel.isError.value,
                      onRetry: viewModel.onInit,
                      child: buildOrderList(context),
                      isConnectNetwork: viewModel.isConnectNetwork.value)),
                  buildOrderList(context),
                  buildOrderList(context),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget buildOrderList(BuildContext context) {
    return SizedBox(
      height: MediaQuery.of(context).size.height * 0.8,
      child: ListView.builder(
          shrinkWrap: true,
          itemCount: viewModel.orderHistories.length,
          itemBuilder: (context, index) {
            return OrderListHistory(
              data: viewModel.orderHistories[index],
            );
          }),
    );
  }

  @override
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    // TODO: implement buildAppBar
    return AppBarTitle(title: 'Lịch sử đơn hàng');
  }
}
