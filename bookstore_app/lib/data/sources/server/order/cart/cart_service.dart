import '../../../../models/response/catalog/product/cart/cart_data.dart';
import '../../../../models/response/order/create_order_response.dart';
import '../../../../models/response/order/order_request.dart';

abstract class CartService {
  Future<CartData> getMyCart();

  Future<void> removeItemFromCart(
      {required String itemId,
      required Function() onSuccess,
      required Function() onFailure});

  Future<CreateOrderResponse?> createOrder(
      {required CreateOrderRequest orderRequest,
      required Function() onSuccess,
      required Function() onFailure});
}
