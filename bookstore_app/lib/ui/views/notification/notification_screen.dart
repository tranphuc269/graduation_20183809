import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../core/base/stateless_view_base.dart';
import '../../widgets/base/base_appbar.dart';
import '../../widgets/base/base_view.dart';
import '../../widgets/notification_title.dart';
import '../profile/screens/order_history/order_detail/order_detail_view.dart';
import 'notification_controller.dart';

class NotificationView extends StateLessViewBase<NotificationController> {
  static const routeName = '/notification_list';

  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return Obx(
      () => BaseView(
          loadingEnabled: viewModel.isLoading.value,
          errorEnabled: viewModel.isError.value,
          onRetry: viewModel.onInit,
          child: ListView.separated(
              shrinkWrap: true,
              physics: const BouncingScrollPhysics(),
              padding: EdgeInsets.zero,
              itemCount: viewModel.notifications.length,
              itemBuilder: (context, index) {
                return GestureDetector(
                  child: NotificationTiles(
                    data: viewModel.notifications[index],
                  ),
                  onTap: () {
                    Get.toNamed(OrderHistoryView.routeName,
                        arguments: viewModel.notifications[index].sourceId);
                  },
                );
              },
              separatorBuilder: (context, index) {
                return const Divider();
              }),
          isConnectNetwork: viewModel.isConnectNetwork.value),
    );
  }

  @override
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    // TODO: implement buildAppBar
    return AppBarTitle(title: 'Thông báo');
  }
}
