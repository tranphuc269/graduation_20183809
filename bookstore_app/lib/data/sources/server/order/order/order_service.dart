import '../../../../models/response/order/order_detail_response.dart';
import '../../../../models/response/order/order_history_list_response.dart';
import '../../../../models/response/order/order_request.dart';
import '../../../../models/response/order/vnpay_order_response.dart';

abstract class IOrderService {
  Future<List<OrderHistoryListData>> getOrderHistories();

  Future<OrderDetailData> getDetailOrder({required orderId});

  Future<VNPayOrderResponse> getPaymentUrlByOrderChecking(
      {required orderCheckingId});

  Future<void> confirmOrder({required OrderConfirmRequest request});
}
