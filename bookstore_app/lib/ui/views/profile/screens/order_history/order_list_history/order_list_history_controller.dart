import 'package:get/get.dart';

import '../../../../../../core/base/base_controller.dart';
import '../../../../../../data/models/response/order/order_history_list_response.dart';
import '../../../../../../data/sources/server/order/order/order_service.dart';

class OrderListHistoryController extends BaseController {
  OrderListHistoryController({required this.orderService});

  final IOrderService orderService;

  final orderHistories = List<OrderHistoryListData>.empty(growable: true).obs;

  @override
  Future<void> onInit() async {
    super.onInit();
    isLoading(true);
    await _getOrderHistory();
    isLoading(false);
  }

  Future<void> _getOrderHistory() async {
    orderHistories
      ..clear()
      ..addAll(await orderService.getOrderHistories());
  }
}