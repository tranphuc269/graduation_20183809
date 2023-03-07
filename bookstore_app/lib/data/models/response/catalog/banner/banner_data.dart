class BannerData {
  BannerData(
      {required this.name,
      required this.id,
      required this.imgUrl,
      required this.navigation});

  factory BannerData.fromJson(Map<String, dynamic> json) {
    return BannerData(
      name: json['name'],
      id: json['id'],
      imgUrl: json['imgUrl'],
      navigation: json['navigation'],
    );
  }

  String id;
  String name;
  String navigation;
  String imgUrl;
}
