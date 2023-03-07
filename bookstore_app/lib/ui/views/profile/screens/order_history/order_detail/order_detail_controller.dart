import 'package:get/get.dart';

import '../../../../../../core/base/base_controller.dart';
import '../../../../../../data/models/response/order/order_detail_response.dart';
import '../../../../../../data/sources/server/order/order/order_service.dart';

class OrderDetailController extends BaseController {
  OrderDetailController({required this.orderId, required this.orderService});

  final String orderId;

  final IOrderService orderService;

  final orderDetailData = Rx<OrderDetailData?>(null);

  @override
  Future<void> onInit() async {
    // TODO: implement onInit
    super.onInit();
    isLoading(true);
    await _getOrderDetail();
    isLoading(false);
  }

  Future<void> _getOrderDetail() async {
    orderDetailData.value = await orderService.getDetailOrder(orderId: orderId);
  }
}
