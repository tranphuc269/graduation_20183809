import 'package:get/get.dart';

import '../../../data/sources/server/order/cart/cart_service_impl.dart';
import 'payment_controller.dart';

class PaymentBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => PaymentController(
        cartService: Get.find<CartServiceImpl>(),
      ),
    );
  }
}
