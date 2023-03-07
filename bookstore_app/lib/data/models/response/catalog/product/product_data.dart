import '../../../../../core/helper/extension/double_extension.dart';

class ProductData {
  ProductData(
      {required this.name,
      required this.images,
      required this.price,
      required this.productId,
      required this.availableItemCount,
      required this.quantitySold,
      required this.description,
      required this.shortContent});

  factory ProductData.fromJson(Map<String, dynamic> json) {
    return ProductData(
        name: json['name'],
        images: (json['images'] as List).map((e) => e.toString()).toList(),
        price: json['price'],
        productId: json['productId'],
        availableItemCount: json['availableItemCount'],
        quantitySold: json['quantitySold'],
        shortContent: json['shortContent'],
        description: json['description'] ?? '');
  }

  String getPrice(){
    return price.formatMoney();
  }

  String productId;
  String name;
  String description;
  String shortContent;
  double price;
  int availableItemCount;
  int quantitySold;
  List<String> images;
}
