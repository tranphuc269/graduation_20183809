import 'package:get/get.dart';

import '../../../data/sources/server/catalog/product/product_service_impl.dart';
import 'detail_controller.dart';

class ProductDetailBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => DetailController(
        productId: Get.arguments,
        productService: Get.find<ProductServiceImpl>(),
      ),
    );
  }
}
