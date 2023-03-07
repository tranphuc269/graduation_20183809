class AddressData {
  AddressData(
      {required this.phoneNumber,
      required this.addressId,
      required this.city,
      required this.createdAt,
      required this.detail,
      required this.district,
      required this.province,
      required this.updatedAt,
      required this.userId,
      required this.userName});

  factory AddressData.fromJson(Map<String, dynamic> json) {
    return AddressData(
      phoneNumber: json['phoneNumber'],
      addressId: json['addressId'],
      city: json['city'],
      createdAt: json['createdAt'],
      detail: json['detail'],
      district: json['district'],
      province: json['province'],
      updatedAt: json['updatedAt'],
      userId: json['userId'],
      userName: json['userName'],
    );
  }

  String? createdAt;
  String? updatedAt;
  String addressId;
  String userId;
  String userName;
  String phoneNumber;
  String city;
  String district;
  String province;
  String detail;
}
