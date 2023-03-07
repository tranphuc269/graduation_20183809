import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:get/get.dart';
import '../../../core/app/app_constant.dart';
import '../../../core/base/stateless_view_base.dart';
import '../../../core/localization/languages/vietnam.dart';
import '../../../core/themes/app_style.dart';
import '../../widgets/empty_session.dart';
import '../../widgets/sub_title.dart';
import '../cart/components/cart_card.dart';
import '../cart/controller/cart_controller.dart';
import 'component/payment_default_button.dart';

class PaymentFailure extends StateLessViewBase<CartController> {
  static const routeName = '/payment_failure';

  @override
  // TODO: implement viewModel
  CartController get viewModel => Get.find<CartController>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: kWhiteColor,
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const EmptySection(
            emptyImg: failure,
            emptyMsg: 'Thất bại !!',
          ),
          const SubTitle(
            subTitleText: 'Quá trình thanh toán thất bại',
          ),
          _buildErrorItem(context),
          PaymentDefaultButton(
            btnText: 'Quay lại',
            onPressed: () {
              while (Navigator.canPop(context)) {
                Navigator.pop(context);
              }
            },
          ),
        ],
      ),
    );
  }

  Widget _buildErrorItem(BuildContext context) {
    if (Get.arguments == null) {
      return SizedBox();
    }
    print((Get.arguments as DioError).response);
    final _errors =
        ((Get.arguments as DioError).response!.data as List<dynamic>)
            .map((e) => ItemError.fromJson(e))
            .toList();
    return SizedBox(
      height: 300,
      child: ListView(
        children: List.generate(
          viewModel.cartData.value?.data.length ?? 0,
          (index) => Stack(
            children: [
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 10),
                child: Dismissible(
                  key: Key(viewModel.cartData.value!.data[index].cartItemId
                      .toString()),
                  direction: DismissDirection.endToStart,
                  onDismissed: (direction) {
                    viewModel.deleteItem(
                        cartItemId:
                            viewModel.cartData.value!.data[index].cartItemId);
                  },
                  background: Container(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    decoration: BoxDecoration(
                      color: const Color(0xFFFFE6E6),
                      borderRadius: BorderRadius.circular(15),
                    ),
                    child: Row(
                      children: [
                        const Spacer(),
                        SvgPicture.asset('assets/icons/Trash.svg'),
                      ],
                    ),
                  ),
                  child: CartCard(cart: viewModel.cartData.value!.data[index]),
                ),
              ),
              if (!_errors[index].isEnough)
                Positioned.fill(
                  child: Container(
                    alignment: Alignment.center,
                    child: ItemErrElement(_errors[index]),
                    color: Colors.black54.withOpacity(0.2),
                  ),
                )
            ],
          ),
        ),
      ),
    );
  }

  Widget ItemErrElement(ItemError itemError) {
    return Text(
      'Không đủ số lượng',
      style: AppStyle.subtitle18
          .copyWith(color: Colors.red, fontWeight: FontWeight.bold),
    );
  }

  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    throw UnimplementedError();
  }
}

class ItemError {
  ItemError({required this.productId, required this.isEnough});

  factory ItemError.fromJson(Map<String, dynamic> json) {
    return ItemError(productId: json['productId'], isEnough: json['enough']);
  }

  String productId;
  bool isEnough;
}
