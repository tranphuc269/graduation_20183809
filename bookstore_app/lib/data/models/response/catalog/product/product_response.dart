import '../../base_response.dart';
import '../author/author_response.dart';
import '../category/category_data.dart';
import 'product_data.dart';

class ProductListResponse extends BaseResponse {
  ProductListResponse({
    required super.meta,
    required this.data,
  });

  factory ProductListResponse.fromJson(Map<String, dynamic> json) {
    return ProductListResponse(
      data: (json['data'] as List).map((e) => ProductData.fromJson(e)).toList(),
      meta: MetaStatus.fromJson(json['meta']),
    );
  }

  List<ProductData> data;
}

class ProductSingleResponse extends BaseResponse {
  ProductSingleResponse({
    required super.meta,
    required this.data,
  });

  factory ProductSingleResponse.fromJson(Map<String, dynamic> json) {
    return ProductSingleResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: ProductDetailData.fromJson(json['data']),
    );
  }

  ProductDetailData data;
}

class ProductDetailData {
  ProductDetailData(
      {required this.name,
      required this.description,
      required this.productId,
      required this.shortContent,
      required this.quantitySold,
      required this.availableItemCount,
      required this.price,
      required this.category,
      required this.author,
      required this.images});

  factory ProductDetailData.fromJson(Map<String, dynamic> json) {
    return ProductDetailData(
      name: json['name'],
      description: json['description'],
      productId: json['productId'],
      shortContent: json['shortContent'],
      quantitySold: json['quantitySold'],
      availableItemCount: json['availableItemCount'],
      price: json['price'],
      category: CategoryData.fromJson(json['category']),
      author: AuthorData.fromJson(json['author']),
      images: (json['images'] as List).map((e) => e.toString()).toList(),
    );
  }

  String productId;
  String name;
  double price;
  String shortContent;
  String description;
  int availableItemCount;
  int quantitySold;
  CategoryData category;
  AuthorData author;
  List<String> images;
}
