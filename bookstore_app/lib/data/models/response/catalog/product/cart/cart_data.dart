import '../../../../../../core/helper/extension/double_extension.dart';
import 'cart_item_data.dart';

class CartData {
  CartData(
      {required this.data, required this.cartId, required this.totalPrice});

  factory CartData.fromJson(Map<String, dynamic> json) {
    return CartData(
        data: (json['items'] as List)
            .map((e) => CartItemData.fromJson(e))
            .toList(),
        cartId: json['cartId'],
        totalPrice: json['totalPrice']);
  }
  String getPrice(){
    return totalPrice.formatMoney();
  }
  String cartId;
  double totalPrice;
  List<CartItemData> data;
}
