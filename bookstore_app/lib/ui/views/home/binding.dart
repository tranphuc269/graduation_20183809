import 'package:get/get.dart';

import '../../../data/sources/server/catalog/category/category_service_impl.dart';
import '../../../data/sources/server/catalog/product/product_service_impl.dart';
import 'controller/home_controller.dart';

class HomeBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => HomeController(
        productService: Get.find<ProductServiceImpl>(),
        categoryService: Get.find<CategoryServiceImpl>(),
      ),
    );
  }
}
