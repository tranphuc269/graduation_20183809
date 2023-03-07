import 'package:get/get.dart';

import '../../../data/sources/server/order/cart/cart_service_impl.dart';
import '../../../data/sources/server/order/order/order_service_impl.dart';
import 'controller/cart_controller.dart';

class CartBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => CartController(
        cartService: Get.find<CartServiceImpl>(),
      ),
    );
  }
}
