import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../core/app/app_constant.dart';
import '../../../core/app/size_config.dart';
import '../../../core/base/stateless_view_base.dart';
import '../../widgets/base/base_view.dart';
import '../../widgets/coustom_bottom_nav_bar.dart';
import 'components/body.dart';
import 'controller/home_controller.dart';

class HomeScreen extends StateLessViewBase<HomeController> {
  static String routeName = '/home';

  @override
  Widget buildBody(BuildContext context) {
    SizeConfig().init(context);
    // TODO: implement buildBody
    return Obx(
      () => BaseView(
          loadingEnabled: viewModel.isLoading.isTrue,
          errorEnabled: viewModel.isError.isTrue,
          onRetry: viewModel.onInit,
          child: HomeBody(),
          isConnectNetwork: viewModel.isConnectNetwork.isTrue),
    );
  }

  @override
  Widget? buildBottomNavigationBar(BuildContext context) {
    // TODO: implement buildBottomNavigationBar
    return const CustomBottomNavBar(selectedMenu: MenuState.home);
  }
}
