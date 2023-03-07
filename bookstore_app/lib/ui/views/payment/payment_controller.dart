import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';

import '../../../core/base/base_controller.dart';
import '../../../core/helper/dialog_helper.dart';
import '../../../data/models/response/order/order_request.dart';
import '../../../data/sources/server/order/cart/cart_service.dart';
import 'payment_fail.dart';
import 'payment_success.dart';

class PaymentController extends BaseController {
  PaymentController({required this.cartService});

  final CartService cartService;

  final indexMethodSelect = 0.obs;

  /// text controller
  final nameController = TextEditingController();
  final phoneNumberController = TextEditingController();
  final detailController = TextEditingController();
  final cityController = TextEditingController();
  final districtController = TextEditingController();

  Future<void> createOrder() async {
    final _createOrderRequest = CreateOrderRequest(
      cartId: 'ff808081855483340185548517d30000',
      paymentMethod: PAYMENT_METHOD.values[indexMethodSelect.value],
      addressRequest: OrderAddressRequest(
          phoneNumber: phoneNumberController.text,
          detail: detailController.text,
          district: districtController.text,
          province: '',
          city: cityController.text,
          userName: nameController.text),
    );
    await cartService.createOrder(
      onSuccess: () {

      },
      onFailure: () {

      },
      orderRequest: _createOrderRequest,
    );
  }
}
