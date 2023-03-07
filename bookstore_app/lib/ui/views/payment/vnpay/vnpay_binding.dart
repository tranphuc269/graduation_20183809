import 'package:get/get.dart';
import '../../../../data/sources/server/order/order/order_service_impl.dart';
import 'vnpay_controller.dart';

class VNPayBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => VNPayController(
        orderCheckingId: Get.arguments,
        orderService: Get.find<OrderServiceImpl>(),
      ),
    );
  }
}
