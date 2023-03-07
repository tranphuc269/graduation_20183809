import '../base_response.dart';
import 'producer_data.dart';

class ProducerResponse extends BaseResponse {
  ProducerResponse({
    required super.meta,
    required this.data,
  });

  factory ProducerResponse.fromJson(Map<String, dynamic> json) {
    return ProducerResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data:
          (json['data'] as List).map((e) => ProducerData.fromJson(e)).toList(),
    );
  }

  List<ProducerData> data;
}
