import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../core/app/app_constant.dart';
import '../../../core/base/stateless_view_base.dart';
import '../../widgets/base/base_appbar.dart';
import '../../widgets/default_text_field.dart';
import '../../widgets/header_label.dart';
import 'component/payment_default_button.dart';
import 'payment_controller.dart';
import 'payment_method.dart';

class PaymentDeliveryAddress extends StateLessViewBase<PaymentController> {
  static const routeName = '/payment_delivery_address';
  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return Column(
      children: [
        const HeaderLabel(
          headerText: 'Nhập địa chỉ giao hàng',
        ),
        const SizedBox(
          height: kFixPadding,
        ),
        DefaultTextField(
          hintText: 'Tên người nhận(*)',
          icon: Icons.person,
          controller: viewModel.nameController,
          obscureText: false,
          keyboardType: TextInputType.number,
        ),
        const SizedBox(
          height: kFixPadding,
        ),
        DefaultTextField(
          hintText: 'Số điện thoại(*)',
          controller: viewModel.phoneNumberController,
          icon: Icons.phone_android,
          obscureText: false,
          keyboardType: TextInputType.number,
        ),
        const SizedBox(
          height: kFixPadding,
        ),
        DefaultTextField(
          hintText: 'Thành phố(*)',
          controller: viewModel.cityController,
          icon: Icons.map_outlined,
          obscureText: false,
          keyboardType: TextInputType.text,
        ),
        const SizedBox(
          height: kFixPadding,
        ),
        DefaultTextField(
          hintText: 'Quận/Huyện(*)',
          icon: Icons.location_on_outlined,
          controller: viewModel.districtController,
          obscureText: false,
          keyboardType: TextInputType.text,
        ),
        const SizedBox(
          height: kFixPadding,
        ),
        DefaultTextField(
          hintText: 'Địa chỉ(*)',
          icon: Icons.location_on_outlined,
          controller: viewModel.detailController,
          obscureText: false,
          keyboardType: TextInputType.text,
        ),
        const SizedBox(
          height: kFixPadding,
        ),
        PaymentDefaultButton(
          btnText: 'Thanh toán',
          onPressed: () {
            Get.toNamed(PaymentMethod.routeName);
          },
        ),
      ],
    );
  }

  @override
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    // TODO: implement buildAppBar
    return AppBarTitle(title: 'Địa chỉ giao hàng');
  }
}
