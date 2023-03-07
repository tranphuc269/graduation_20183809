import 'package:get/get.dart';

import '../../../../../../data/sources/server/order/order/order_service_impl.dart';
import 'order_detail_controller.dart';

class OrderDetailBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => OrderDetailController(
        orderId: Get.arguments,
        orderService: Get.find<OrderServiceImpl>(),
      ),
    );
  }
}
