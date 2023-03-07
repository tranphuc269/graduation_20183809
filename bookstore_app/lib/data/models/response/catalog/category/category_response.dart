import '../../base_response.dart';
import 'category_data.dart';

class CategoryResponse extends BaseResponse {
  CategoryResponse({required super.meta, required this.data});

  factory CategoryResponse.fromJson(Map<String, dynamic> json) {
    return CategoryResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data:
          (json['data'] as List).map((e) => CategoryData.fromJson(e)).toList(),
    );
  }

  List<CategoryData> data;
}
