import 'package:flutter/services.dart';
import 'package:get/get.dart';

import '../../../../core/base/base_controller.dart';
import '../../../../data/models/response/order/order_request.dart';
import '../../../../data/sources/server/order/order/order_service.dart';

class VNPayController extends BaseController {
  VNPayController({required this.orderCheckingId, required this.orderService});

  final String orderCheckingId;

  final IOrderService orderService;

  String paymentUrl = '';

  @override
  Future<void> onInit() async {
    isLoading(true);
    await _initPlatformState();
    isLoading(false);
    super.onInit();
  }

  Future<void> _initPlatformState() async {
    final _vnpayResponse = await orderService.getPaymentUrlByOrderChecking(
        orderCheckingId: orderCheckingId);
    paymentUrl = _vnpayResponse.data;
  }

  void confirmOrder() {
    orderService.confirmOrder(
        request: OrderConfirmRequest(orderCheckingId: orderCheckingId));
  }
}
