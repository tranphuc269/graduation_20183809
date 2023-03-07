import '../../base_response.dart';
import 'banner_data.dart';

class BannerResponse extends BaseResponse {
  BannerResponse(
      {required super.meta,required this.data});

  factory BannerResponse.fromJson(Map<String, dynamic> json) {
    return BannerResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: (json['data'] as List).map((e) => BannerData.fromJson(e)).toList(),
    );
  }

  List<BannerData> data;
}
