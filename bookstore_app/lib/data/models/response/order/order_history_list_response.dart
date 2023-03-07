import '../../../../core/helper/extension/datetime_extension.dart';
import '../../../../core/helper/extension/double_extension.dart';
import '../../../../core/helper/extension/string_extension.dart';
import '../base_response.dart';

class OrderHistoryListResponse extends BaseResponse {
  OrderHistoryListResponse({required super.meta, required this.data});

  factory OrderHistoryListResponse.fromJson(Map<String, dynamic> json) {
    return OrderHistoryListResponse(
      meta: MetaStatus.fromJson(json['meta']),
      data: ((json['data'] ?? []) as List)
          .map((e) => OrderHistoryListData.fromJson(e))
          .toList(),
    );
  }

  List<OrderHistoryListData> data;
}

class OrderHistoryListData {
  OrderHistoryListData(
      {required this.orderId,
      required this.paymentMethod,
      required this.totalPrice,
      required this.createdAt,
      required this.orderCheckingId,
      required this.orderStatus,
      required this.paymentStatus,
      required this.totalItem});

  factory OrderHistoryListData.fromJson(Map<String, dynamic> json) {
    return OrderHistoryListData(
      orderId: json['orderId'],
      paymentMethod: json['paymentMethod'],
      totalPrice: (json['totalPrice'] ?? 0).toDouble(),
      createdAt: json['createdAt'],
      orderCheckingId: json['orderCheckingId'],
      orderStatus: json['orderStatus'],
      paymentStatus: json['paymentStatus'],
      totalItem: json['totalItem'],
    );
  }

  String getTotalPrice() {
    return totalPrice.formatMoney();
  }

  String getTotalItem() {
    return totalItem.toString();
  }

  String getTrackingOrderId() {
    return orderCheckingId.split('-').first.toUpperCase();
  }

  String getShortOrderId() {
    return orderId.split('-').first.toUpperCase();
  }

  String getFormatDate() {
    return orderId.split('-').first.toUpperCase();
  }

  String getCreatedDate() {
    return createdAt.toDate().toddMMYYYY();
  }

  String orderId;
  String orderCheckingId;
  String orderStatus;
  String paymentMethod;
  String paymentStatus;
  String createdAt;
  int totalItem;
  double totalPrice;
}
