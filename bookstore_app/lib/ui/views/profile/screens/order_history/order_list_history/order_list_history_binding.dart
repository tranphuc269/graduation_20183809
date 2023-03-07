import 'package:get/get.dart';

import '../../../../../../data/sources/server/order/order/order_service_impl.dart';
import 'order_list_history_controller.dart';

class OrderListHistoryBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => OrderListHistoryController(
        orderService: Get.find<OrderServiceImpl>(),
      ),
    );
  }
}
