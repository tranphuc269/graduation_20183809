import '../base_response.dart';

class CreateOrderResponse extends BaseResponse {
  CreateOrderResponse({required super.meta, required this.data});

  factory CreateOrderResponse.fromJson(Map<String, dynamic> json) {
    return CreateOrderResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: json['data'],
    );
  }

  String data;
}
