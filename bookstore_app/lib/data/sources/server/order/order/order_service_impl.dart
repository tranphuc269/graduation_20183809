import '../../../../../core/network/api_request.dart';
import '../../../../models/response/order/order_detail_response.dart';
import '../../../../models/response/order/order_history_list_response.dart';
import '../../../../models/response/order/order_request.dart';
import '../../../../models/response/order/vnpay_order_response.dart';
import 'order_service.dart';

class OrderServiceImpl extends IOrderService {
  @override
  Future<List<OrderHistoryListData>> getOrderHistories() async {
    // TODO: implement getOrderHistories
    const url = '/order-service/order/histories';
    final _res = await sendRequest(
      url: url,
      requestMethod: RequestMethod.GET,
      useToken: true,
    );
    final OrderHistoryListResponse cart =
        OrderHistoryListResponse.fromJson(_res.data);
    return cart.data;
  }

  @override
  Future<OrderDetailData> getDetailOrder({required orderId}) async {
    // TODO: implement getDetailOrder
    final url = '/order-service/order/detail/$orderId';
    final _res = await sendRequest(
      url: url,
      requestMethod: RequestMethod.GET,
      useToken: true,
    );
    final response = OrderDetailResponse.fromJson(_res.data);
    return response.data;
  }

  @override
  Future<VNPayOrderResponse> getPaymentUrlByOrderChecking(
      {required orderCheckingId}) async {
    // TODO: implement getPaymentUrlByOrderChecking
    final url = '/order-service/order/vnpay-url/$orderCheckingId';
    final _res = await sendRequest(
      url: url,
      requestMethod: RequestMethod.GET,
      useToken: true,
    );
    final response = VNPayOrderResponse.fromJson(_res.data);
    return response;
  }

  @override
  Future<void> confirmOrder({required OrderConfirmRequest request}) async {
    // TODO: implement confirmOrder
    const url = '/order-service/order/confirm';
    await sendRequest(
        url: url,
        requestMethod: RequestMethod.POST,
        useToken: true,
        body: request.toJson());
  }
}
