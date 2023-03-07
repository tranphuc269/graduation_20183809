import 'package:get/get.dart';

import '../../../../core/base/base_controller.dart';
import '../../../../data/models/response/catalog/category/category_data.dart';
import '../../../../data/models/response/catalog/product/product_data.dart';
import '../../../../data/sources/server/catalog/category/category_service.dart';
import '../../../../data/sources/server/catalog/product/product_service.dart';

class HomeController extends BaseController {
  HomeController({required this.productService, required this.categoryService});

  final ProductService productService;
  final CategoryService categoryService;

  final products = List<ProductData>.empty(growable: true).obs;
  final categories = List<CategoryData>.empty(growable: true).obs;

  @override
  Future<void> onInit() async {
    isLoading(true);

    await _initialize();
    super.onInit();

    isLoading(false);
  }

  Future<void> _initialize() async {
    await Future.wait([getProducts(), getCategories()]);
  }

  Future<void> getProducts() async {
    products
      ..clear()
      ..addAll(
          await productService.getProductBySortPageSize(page: 0, size: 10));
  }

  Future<void> getCategories() async {
    categories.clear();
    final _categories = await categoryService.getCategory();

    for (int i = _categories.length - 1; i >= 0; i--) {
      categories.add(_categories[i]);
    }
  }
}
