import 'package:flutter/material.dart';
import 'package:get/get_state_manager/src/rx_flutter/rx_obx_widget.dart';
import '../../../core/base/stateless_view_base.dart';
import '../../../data/models/response/catalog/product/product_data.dart';
import '../../widgets/base/base_view.dart';
import 'components/body.dart';
import 'components/custom_app_bar.dart';
import 'detail_controller.dart';

class DetailsScreen extends StateLessViewBase<DetailController> {
  static String routeName = '/details';

  ///const Color(0xFFF5F6F9),
  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return Obx(
      () => BaseView(
          loadingEnabled: viewModel.isLoading.value,
          errorEnabled: viewModel.isError.value,
          onRetry: viewModel.onInit,
          child: viewModel.productData.value == null
              ? Container()
              : ProductDetailBody(product: viewModel.productData.value!),
          isConnectNetwork: viewModel.isConnectNetwork.value),
    );
  }

  @override
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    // TODO: implement buildAppBar
    return PreferredSize(
      preferredSize: Size.fromHeight(AppBar().preferredSize.height),
      child: CustomAppBar(rating: 4.1),
    );
  }
}
