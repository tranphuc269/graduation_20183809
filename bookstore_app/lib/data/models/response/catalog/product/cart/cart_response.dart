import '../../../base_response.dart';
import '../product_data.dart';
import 'cart_data.dart';

class CartResponse extends BaseResponse {
  CartResponse({
    required super.meta,
    required this.data,
  });

  factory CartResponse.fromJson(Map<String, dynamic> json) {
    return CartResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: CartData.fromJson(json['data']),
    );
  }

  CartData data;
}
