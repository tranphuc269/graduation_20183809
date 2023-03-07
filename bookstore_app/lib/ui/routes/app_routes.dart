import 'package:get/get.dart';

import '../views/cart/cart_binding.dart';
import '../views/cart/cart_screen.dart';
import '../views/complete_profile/complete_profile_screen.dart';
import '../views/details/details_screen.dart';
import '../views/details/product_detail_binding.dart';
import '../views/forgot_password/forgot_password_screen.dart';
import '../views/home/binding.dart';
import '../views/home/home_screen.dart';
import '../views/login_success/login_success_screen.dart';
import '../views/notification/notification_bindings.dart';
import '../views/notification/notification_screen.dart';
import '../views/otp/otp_screen.dart';
import '../views/payment/payment_binding.dart';
import '../views/payment/payment_delivery_address.dart';
import '../views/payment/payment_fail.dart';
import '../views/payment/payment_method.dart';
import '../views/payment/payment_success.dart';
import '../views/payment/vnpay/vnpay_binding.dart';
import '../views/payment/vnpay/vnpay_view.dart';
import '../views/profile/profile_screen.dart';
import '../views/profile/screens/order_history/order_detail/order_detail_binding.dart';
import '../views/profile/screens/order_history/order_detail/order_detail_view.dart';
import '../views/profile/screens/order_history/order_list_history/order_list_history_binding.dart';
import '../views/profile/screens/order_history/order_list_history/order_list_history_view.dart';
import '../views/sign_in/sign_in_screen.dart';
import '../views/sign_up/sign_up_screen.dart';
import '../views/splash/splash_screen.dart';

class AppPages {
  static const initial = ' MainNavView.route';

  static final routes = <GetPage>[
    GetPage(
      name: DetailsScreen.routeName,
      page: () => DetailsScreen(),
      binding: ProductDetailBinding(),
    ),
    GetPage(
      name: SplashScreen.routeName,
      page: () => SplashScreen(),
    ),
    GetPage(
      name: HomeScreen.routeName,
      page: () => HomeScreen(),
      binding: HomeBinding(),
    ),
    GetPage(
      name: ForgotPasswordScreen.routeName,
      page: () => ForgotPasswordScreen(),
    ),
    GetPage(
      name: CartScreen.routeName,
      page: () => CartScreen(),
      binding: CartBinding(),
    ),
    GetPage(
        name: CompleteProfileScreen.routeName,
        page: () => CompleteProfileScreen()),
    GetPage(
      name: SignUpScreen.routeName,
      page: () => SignUpScreen(),
    ),
    GetPage(
      name: SignInScreen.routeName,
      page: () => SignInScreen(),
    ),
    GetPage(
      name: ProfileScreen.routeName,
      page: () => ProfileScreen(),
    ),
    GetPage(
      name: LoginSuccessScreen.routeName,
      page: () => LoginSuccessScreen(),
    ),
    GetPage(
      name: OtpScreen.routeName,
      page: () => OtpScreen(),
    ),
    GetPage(
      name: PaymentSuccess.routeName,
      page: () => PaymentSuccess(),
    ),
    GetPage(
      name: PaymentFailure.routeName,
      page: () => PaymentFailure(),
    ),
    GetPage(
      name: VNPayView.routeName,
      page: () => VNPayView(),
      binding: VNPayBinding(),
    ),
    GetPage(
      name: OrderListHistoryView.routeName,
      page: () => OrderListHistoryView(),
      binding: OrderListHistoryBinding(),
    ),
    GetPage(
      name: OrderHistoryView.routeName,
      page: () => OrderHistoryView(),
      binding: OrderDetailBinding(),
    ),
    GetPage(
      name: PaymentMethod.routeName,
      page: () => PaymentMethod(),
    ),
    GetPage(
      name: NotificationView.routeName,
      page: () => NotificationView(),
      binding: NotificationBinding(),
    ),
    GetPage(
      name: PaymentDeliveryAddress.routeName,
      page: () => PaymentDeliveryAddress(),
      binding: PaymentBinding(),
    ),
  ];
}
