import 'package:dio/dio.dart';
import 'package:get/get.dart';

import '../../../../../core/helper/dialog_helper.dart';
import '../../../../../core/network/api_request.dart';
import '../../../../../ui/views/payment/payment_fail.dart';
import '../../../../../ui/views/payment/payment_success.dart';
import '../../../../../ui/views/payment/vnpay/vnpay_view.dart';
import '../../../../models/response/catalog/product/cart/cart_data.dart';
import '../../../../models/response/catalog/product/cart/cart_response.dart';
import '../../../../models/response/order/create_order_response.dart';
import '../../../../models/response/order/order_request.dart';
import 'cart_service.dart';

class CartServiceImpl extends CartService {
  @override
  Future<CartData> getMyCart() async {
    // TODO: implement getMyCart
    const url = '/order-service/cart/ff808081855483340185548517d30000';
    final _res = await sendRequest(
      url: url,
      requestMethod: RequestMethod.GET,
      useToken: true,
    );
    final CartResponse cart = CartResponse.fromJson(_res.data);
    return cart.data;
  }

  @override
  Future<CreateOrderResponse?> createOrder(
      {required CreateOrderRequest orderRequest,
      required Function() onSuccess,
      required Function() onFailure}) async {
    // TODO: implement createOrder
    try {
      const url = '/order-service/order';
      // TODO: implement getProductBySortPageSize
      final _res = await sendRequest(
        url: url,
        requestMethod: RequestMethod.POST,
        useToken: true,
        body: orderRequest.toJson(),
      );
      AppDialog.show(
          message: 'Bạn đã đặt hàng thành công',
          onPress: () {
            Get.back();
            Get.toNamed(VNPayView.routeName,
                arguments: CreateOrderResponse.fromJson(_res.data).data);
          },
          typeDialog: TypeDialog.SUCCESS);
      return CreateOrderResponse.fromJson(_res.data);
    } on Exception catch (e) {
      AppDialog.show(
          message: 'Có lỗi xảy ra, vui lòng thử lạiaa',
          onPress: () {
            Get.back();
            Get.toNamed(PaymentFailure.routeName, arguments: e);
          },
          typeDialog: TypeDialog.FAILED);
    }
  }

  @override
  Future<void> removeItemFromCart(
      {required String itemId,
      required Function() onSuccess,
      required Function() onFailure}) async {
    // TODO: implement removeItemFromCart
    try {
      const url = '/order-service/cart-item';
      await sendRequest(
        url: url,
        requestMethod: RequestMethod.DELETE,
        body: {
          'cartItemId': itemId,
        },
        useToken: true,
      );
      onSuccess.call();
    } on Exception {
      onFailure.call();
    }
  }
}
