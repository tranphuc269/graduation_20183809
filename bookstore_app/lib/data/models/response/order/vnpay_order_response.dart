import '../base_response.dart';

class VNPayOrderResponse extends BaseResponse {
  VNPayOrderResponse({required super.meta, required this.data});

  factory VNPayOrderResponse.fromJson(Map<String, dynamic> json) {
    return VNPayOrderResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: json['data'],
    );
  }

  String data;
}