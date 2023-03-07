import '../../../base_response.dart';

class CartAddedResponse extends BaseResponse {
  CartAddedResponse({
    required super.meta,
    required this.data,
  });

  factory CartAddedResponse.fromJson(Map<String, dynamic> json) {
    return CartAddedResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: json['data'],
    );
  }

  String data;
}
