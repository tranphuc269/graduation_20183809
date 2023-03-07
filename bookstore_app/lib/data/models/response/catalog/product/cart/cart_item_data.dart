import '../../../../../../core/helper/extension/double_extension.dart';

class CartItemData {
  CartItemData(
      {required this.productName,
      required this.productId,
      required this.quantity,
      required this.cartItemId,
      required this.images,
      required this.productPrice,
      required this.productShortContent});

  factory CartItemData.fromJson(Map<String, dynamic> json) {
    return CartItemData(
      productName: json['productName'],
      productId: json['productId'],
      quantity: json['quantity'],
      cartItemId: json['cartItemId'],
      productPrice: json['productPrice'],
      productShortContent: json['productShortContent'],
      images: (json['images'] as List).map((e) => e.toString()).toList(),
    );
  }

  String getPrice(){
    return productPrice.formatMoney();
  }



  String cartItemId;
  String productId;
  double productPrice;
  String productName;
  String productShortContent;
  int quantity;
  List<String> images;
}
