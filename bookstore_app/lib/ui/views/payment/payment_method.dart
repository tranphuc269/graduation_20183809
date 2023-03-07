import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../core/app/app_constant.dart';
import '../../../core/base/stateless_view_base.dart';
import '../../widgets/base/base_appbar.dart';
import '../../widgets/cached_image.dart';
import 'component/payment_default_button.dart';
import 'component/payment_header_label.dart';
import 'payment_controller.dart';

final paymentLabels = [
  'Thanh toán khi nhận hàng',
  'Ví VNPAY',
  'Chuyển khoản',
];

final paymentIcons = [
  'https://cdn-icons-png.flaticon.com/512/5167/5167381.png',
  'https://inkythuatso.com/uploads/images/2021/12/vnpay-logo-inkythuatso-01-13-16-26-42.jpg',
  'https://img.freepik.com/premium-vector/bank-icon-white-background_539296-81.jpg?w=2000',
];

class PaymentMethod extends StateLessViewBase<PaymentController> {
  static const routeName = '/select_payment_method';

  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return Column(
      children: [
        const PaymentHeaderLabel(
          headerText: 'Chọn phương thức thanh toán',
        ),
        Expanded(
          child: ListView.separated(
            itemCount: paymentLabels.length,
            itemBuilder: (context, index) {
              return Obx(
                () => ListTile(
                  leading: Radio(
                    activeColor: kPrimaryColor,
                    value: index,
                    groupValue: viewModel.indexMethodSelect.value,
                    onChanged: (value) {
                      viewModel.indexMethodSelect(value);
                    },
                  ),
                  title: Text(
                    paymentLabels[index],
                    style: const TextStyle(color: kDarkColor),
                  ),
                  trailing: SizedBox(
                    width: 60,
                    height: 60,
                    child: CachedImage(
                      url: paymentIcons[index],
                      fit: BoxFit.contain,
                      borderRadius: BorderRadius.circular(0),
                    ),
                  ),
                ),
              );
            },
            separatorBuilder: (context, index) {
              return const Divider();
            },
          ),
        ),
        PaymentDefaultButton(
          btnText: 'Thanh toán',
          onPressed: () {
            viewModel.createOrder();
            // Get.toNamed(VNPayView.routeName);
          },
        ),
      ],
    );
  }

  @override
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    // TODO: implement buildAppBar
    return AppBarTitle(
      title: 'Thanh toán',
    );
  }
}
