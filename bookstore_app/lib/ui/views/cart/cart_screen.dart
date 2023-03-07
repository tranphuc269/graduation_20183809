import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../../../core/base/stateless_view_base.dart';
import '../../widgets/base/base_view.dart';
import 'components/body.dart';
import 'components/check_out_card.dart';
import 'controller/cart_controller.dart';

class CartScreen extends StateLessViewBase<CartController> {
  static String routeName = '/cart';

  @override
  AppBar buildAppBar(BuildContext context) {
    return AppBar(
      elevation: 0.5,
      title: Column(
        children: [
          const Text(
            'Giỏ hàng của bạn',
            style: TextStyle(color: Colors.black),
          ),
          Obx(
            () => Text(
              '${viewModel.cartData.value?.data.length ?? 0} sản phẩm',
              style: Theme.of(context).textTheme.caption,
            ),
          )
        ],
      ),
    );
  }

  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return Obx(
      () => BaseView(
          loadingEnabled: viewModel.isLoading.isTrue,
          errorEnabled: viewModel.isError.isTrue,
          onRetry: viewModel.onInit,
          child: CartBody(),
          isConnectNetwork: viewModel.isConnectNetwork.isTrue),
    );
  }

  @override
  Widget? buildBottomNavigationBar(BuildContext context) {
    // TODO: implement buildBottomNavigationBar
    return CheckoutCard();
  }
}
