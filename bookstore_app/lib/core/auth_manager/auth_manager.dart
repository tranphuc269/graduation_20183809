import 'dart:async';

import 'package:get/get.dart';

import '../../data/models/response/user/user.dart';
import '../../data/sources/server/auth/auth_api_impl.dart';
import '../database/get_storage/get_storage_key.dart';
import '../database/get_storage/get_storage_manager.dart';
import '../database/secure_storage/secure_storage_manager.dart';
import '../themes/theme_manager.dart';
import 'auth_state.dart';


/// This class will called first time before app go to pages.
///
/// This class help you to manage authentication process.
/// Contains auth general function such as [login], [logout], and first install/[setup]
class AuthManager extends GetxController {
  static AuthManager get find => Get.find<AuthManager>();

  Rxn<AuthState> authState = Rxn<AuthState>();
  Stream<AuthState?> get stream => authState.stream;
  AuthState? get state => authState.value;

  var getStorage = GetStorageManager.find;
  var secureStorage = SecureStorageManager.find;
  var themeManager = ThemeManager.find;

  @override
  void onInit() {
    authState.value = const AuthState(appStatus: AppType.INITIAL);
    super.onInit();
  }

  @override
  Future<void> onReady() async {
    // ever(authState, authChanged);
    // authChanged(state);
    // Timer(
    //   const Duration(seconds: 2),
    //       () => Get.offAllNamed(MainNavView.route),
    // );
    super.onReady();
  }

  Future<void> authChanged(AuthState? state) async {
    // switch (state?.appStatus) {
    //   case AppType.INITIAL:
    //     await setup();
    //     break;
    //   case AppType.FIRST_INSTALL:
    //     Timer(
    //       const Duration(seconds: 2),
    //           () => Get.offAllNamed(IntroView.route),
    //     );
    //     break;
    //   case AppType.UNAUTHENTICATED:
    //     Timer(
    //       const Duration(seconds: 2),
    //           () => Get.offAllNamed(LoginView.route),
    //     );
    //     break;
    //   case AppType.AUTHENTICATED:
    //     await Get.offAllNamed(MainNavView.route);
    //     break;
    //   default:
    //     await Get.toNamed(SplashView.route);
    // }
    update();
  }

  setup() async {
    await checkFirstInstall();
    await checkAppTheme();
  }

  /// Check if app is first time installed. It will navigate to Introduction Page
  Future<void> checkFirstInstall() async {
    final bool firstInstall = getStorage.get(GetStorageKey.FIRST_INSTALL) ?? true;
    if (firstInstall) {
      await secureStorage.setToken(value: '');
      authState.value = const AuthState(appStatus: AppType.FIRST_INSTALL);
    } else {
      await checkUser();
    }
  }

  /// Checking App Theme set it before app display
  Future<void> checkAppTheme() async {
    final bool isDarkTheme = await getStorage.getAwait(GetStorageKey.DARK_THEME) ?? false;
    if(isDarkTheme) {
      themeManager.toDarkMode();
    } else {
      themeManager.toLightMode();
    }
  }

  /// This function to used for checking is valid token to API Server use GET User Endpoint (token required).
  /// If response is Error it will passed to [logout] process.
  Future<void> checkUser() async {
    final AuthApiImpl authApi = AuthApiImpl();
    final String? _token = await secureStorage.getToken();
    final User? _user = getStorage.get(GetStorageKey.USERS);

    try {
      await authApi
          .verifyToken(userId: _user?.id ?? 0, token: _token.toString())
          .then((res) async {
        await setAuth();
      });
    } catch (err) {
      await logout();
    }
  }

  /// Set auth state to AppType.AUTHENTICATED
  Future<void> setAuth() async {
    if (await secureStorage.isLoggedIn()) {
      authState.value = const AuthState(appStatus: AppType.AUTHENTICATED);
    }
  }

  /// Just call this function to managed logout process.
  /// It will stream state and auto redirect your apps to page based on their state
  /// with [authChanged] function
  /// * No need to navigate manually (Get.to or Get.off)
  Future<void> logout() async {
    Get.back();
    await secureStorage.logout();
    getStorage.logout();
    authState.value = const AuthState(appStatus: AppType.UNAUTHENTICATED);
  }

  /// Just call this function to managed login process.
  /// It will stream state and auto redirect your apps to page based on their state
  /// with [authChanged] function
  /// * No need to navigate manually (Get.to or Get.off).
  Future<void> login({
    required User user,
    required String token,
    required String refreshToken,
  }) async {
    await saveAuthData(user: user, token: token, refreshToken: refreshToken);
    await setAuth();
  }

  Future<void> saveAuthData({
    required User user,
    required String token,
    required String refreshToken,
  }) async {
    getStorage.save(GetStorageKey.USERS, user.toJson());
    await secureStorage.setToken(value: token);
    await secureStorage.setRefreshToken(value: refreshToken);
  }

  /// Get User data from GetStorage
  /// * No need to decode or call fromJson again when you used this helper
  User? get user {
    if (getStorage.has(GetStorageKey.USERS)) {
      return User.fromJson(getStorage.get(GetStorageKey.USERS));
    } else {
      return null;
    }
  }
}