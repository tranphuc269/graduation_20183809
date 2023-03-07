import '../../../../core/helper/extension/datetime_extension.dart';
import '../../../../core/helper/extension/string_extension.dart';
import '../base_response.dart';

class OrderDetailResponse extends BaseResponse {
  OrderDetailResponse({required super.meta, required this.data});

  factory OrderDetailResponse.fromJson(Map<String, dynamic> json) {
    return OrderDetailResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: OrderDetailData.fromJson(json['data']),
    );
  }

  OrderDetailData data;
}

class OrderDetailData {
  OrderDetailData(
      {required this.paymentMethod,
      required this.orderStatus,
      required this.paymentStatus,
      required this.orderCheckingId,
      required this.orderId,
      required this.shippingAddress,
      required this.orderItems,
      required this.updatedAt,
      required this.trackingOrderStatuses});

  factory OrderDetailData.fromJson(Map<String, dynamic> json) {
    return OrderDetailData(
      paymentMethod: json['paymentMethod'],
      orderStatus: json['orderStatus'],
      paymentStatus: json['paymentStatus'],
      orderCheckingId: json['orderCheckingId'],
      orderId: json['orderId'],
      shippingAddress: OrderShippingAddress.fromJson(json['shippingAddress']),
      orderItems: (json['orderItems'] as List)
          .map((e) => OrderItemData.fromJson(e))
          .toList(),
      trackingOrderStatuses: (json['trackingOrderStatuses'] as List)
          .map((e) => OrderTracking.fromJson(e))
          .toList(),
      updatedAt: json['updatedAt'],
    );
  }

  String getUpdatedAt() {
    return 'Cập nhật gần nhất: ${updatedAt.toDate().toHHmmddMMYYYYVi()}';
  }

  String getOrderId() {
    return orderId.split('-').first.toUpperCase();
  }

  String orderId;
  String orderCheckingId;
  String orderStatus;
  String paymentMethod;
  String paymentStatus;
  String updatedAt;
  List<OrderItemData> orderItems;

  OrderShippingAddress shippingAddress;

  List<OrderTracking> trackingOrderStatuses;
}

class OrderItemData {
  OrderItemData(
      {required this.productId,
      required this.images,
      required this.quantity,
      required this.productPrice,
      required this.productName,
      required this.orderItemId,
      required this.productShortContent});

  factory OrderItemData.fromJson(Map<String, dynamic> json) {
    return OrderItemData(
      productId: json['productId'],
      images: (json['images'] as List).map((e) => e.toString()).toList(),
      quantity: json['quantity'],
      productPrice: json['productPrice'],
      productName: json['productName'],
      orderItemId: json['orderItemId'],
      productShortContent: json['productShortContent'],
    );
  }

  String orderItemId;
  String productId;
  double productPrice;
  String productName;
  String productShortContent;
  List<String> images;
  int quantity;
}

class OrderTracking {
  OrderTracking({
    required this.orderStatus,
    required this.paymentMethod,
    required this.cartId,
    required this.id,
    required this.userId,
    required this.createdDate,
  });

  factory OrderTracking.fromJson(Map<String, dynamic> json) {
    return OrderTracking(
      orderStatus: json['orderStatus'],
      paymentMethod: json['paymentMethod'],
      cartId: json['cartId'],
      id: json['id'],
      userId: json['userId'],
      createdDate: json['createdDate'],
    );
  }

  String id;
  String createdDate;
  String paymentMethod;
  String orderStatus;
  String userId;
  String cartId;
}

class OrderShippingAddress {
  OrderShippingAddress(
      {required this.city,
      required this.province,
      required this.district,
      required this.detail,
      required this.addressId,
      required this.phoneNumber,
      required this.userName});

  factory OrderShippingAddress.fromJson(Map<String, dynamic> json) {
    return OrderShippingAddress(
      city: json['city'],
      province: json['province'],
      district: json['district'],
      detail: json['detail'],
      addressId: json['addressId'],
      phoneNumber: json['phoneNumber'],
      userName: json['userName'],
    );
  }

  String getAddress() {
    return '$detail, $district, $city';
  }

  String getPhoneNumber() {
    return phoneNumber;
  }

  String getName() {
    return userName;
  }

  String addressId;
  String city;
  String detail;
  String district;
  String phoneNumber;
  String province;
  String userName;
}
