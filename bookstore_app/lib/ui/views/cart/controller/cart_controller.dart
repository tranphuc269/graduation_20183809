import 'package:get/get.dart';

import '../../../../core/base/base_controller.dart';
import '../../../../core/helper/dialog_helper.dart';
import '../../../../data/models/response/catalog/product/cart/cart_data.dart';
import '../../../../data/sources/server/order/cart/cart_service.dart';
import '../../payment/payment_delivery_address.dart';

class CartController extends BaseController {
  CartController({
    required this.cartService,
  });

  final CartService cartService;

  final cartData = Rx<CartData?>(null);

  @override
  Future<void> onInit() async {
    // TODO: implement onInit
    isLoading(true);
    await _initialize();
    isLoading(false);
    super.onInit();
  }

  Future<void> _initialize() async {
    await Future.wait([getCart()]);
  }

  Future<void> getCart() async {
    cartData.value = await cartService.getMyCart();
  }

  Future<void> deleteItem({required String cartItemId}) async {
    await cartService.removeItemFromCart(
        itemId: cartItemId,
        onSuccess: () {
          AppDialog.show(
              message: 'Bạn đã xoá sản phẩm',
              onPress: () {
                getCart();
                Get.back();
              },
              typeDialog: TypeDialog.SUCCESS);
        },
        onFailure: () {
          AppDialog.show(
              message: 'Có lỗi xảy ra, vui lòng thử lại',
              onPress: () {
                getCart();
                Get.back();
              },
              typeDialog: TypeDialog.FAILED);
        });
  }

  void checkout() {
    Get.toNamed(PaymentDeliveryAddress.routeName);
    // await cartService.createOrder(
    //   onSuccess: () {
    //     AppDialog.show(
    //         message: 'Đơn hàng đã được tạo, bấm OK để thanh toán',
    //         onPress: () {
    //           getCart();
    //           Get.back();
    //         },
    //         typeDialog: TypeDialog.SUCCESS);
    //   },
    //   onFailure: () {
    //     AppDialog.show(
    //         message: 'Có lỗi xảy ra, vui lòng thử lại',
    //         onPress: () {
    //           getCart();
    //           Get.back();
    //         },
    //         typeDialog: TypeDialog.FAILED);
    //   },
    //   orderRequest:
    //       CreateOrderRequest(cartId: '', paymentMethod: PAYMENT_METHOD.VNPAY),
    // );
  }
}
