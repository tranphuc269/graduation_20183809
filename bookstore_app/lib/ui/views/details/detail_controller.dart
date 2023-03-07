import 'package:get/get.dart';

import '../../../core/base/base_controller.dart';
import '../../../data/models/response/catalog/product/product_response.dart';
import '../../../data/sources/server/catalog/product/product_service.dart';

class DetailController extends BaseController {
  DetailController({
    required this.productId,
    required this.productService,
  });

  final String productId;
  final ProductService productService;

  final productData = Rx<ProductDetailData?>(null);

  @override
  Future<void> onInit() async {
    // TODO: implement onInit
    super.onInit();
    isLoading(true);
    await _getDetailProduct();
    isLoading(false);
  }

  Future<void> _getDetailProduct() async {
    try {
      productData(await productService.getSingleProduct(productId: productId));
    } on Exception catch (e) {
      isError(true);
    }
  }
}
