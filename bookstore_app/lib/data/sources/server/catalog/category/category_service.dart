import '../../../../models/response/catalog/category/category_data.dart';

abstract class CategoryService {
  Future<List<CategoryData>> getCategory();
}