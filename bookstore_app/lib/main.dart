import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:package_info_plus/package_info_plus.dart';

import 'app_configuration.dart';
import 'core/app/app_env.dart';
import 'core/app/app_info.dart';
import 'core/database/secure_storage/secure_storage_manager.dart';
import 'core/localization/app_translations.dart';
import 'core/localization/locale_helper.dart';
import 'core/themes/app_theme.dart';
import 'core/themes/theme_manager.dart';
import 'initializer.dart';
import 'ui/routes/app_routes.dart';
import 'ui/views/home/home_screen.dart';
import 'ui/views/sign_in/sign_in_screen.dart';

const NGROK_URL = 'https://22b3-27-3-64-175.ap.ngrok.io';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Initializer.init();
  AppInfo.setInfo(await PackageInfo.fromPlatform());
  AppConfiguration.developmentAPI = NGROK_URL;
  AppEnv.set(Env.DEVELOPMENT);
  final _isLogin = await authChecked();
  runApp(App(
    isUserLoggedIn: _isLogin,
  ));
}

class App extends StatelessWidget {
  const App({required this.isUserLoggedIn, Key? key}) : super(key: key);
  final bool isUserLoggedIn;

  @override
  Widget build(BuildContext context) {
    return GetX<ThemeManager>(
      builder: (ctr) => GetMaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'BookStore',
        theme: lightTheme,
        darkTheme: darkTheme,
        themeMode: (ctr.isDark.isTrue) ? ThemeMode.dark : ThemeMode.light,
        translations: AppTranslation(),
        locale: LocaleHelper().getCurrentLocale(),
        fallbackLocale: LocaleHelper().fallbackLocale,
        getPages: AppPages.routes,
        initialRoute: HomeScreen.routeName,
        // initialRoute: SignInScreen.routeName,

        // initialRoute: OrderListHistoryView.routeName,
      ),
    );
  }
}

Future<bool> authChecked() async {
  final _secure = Get.find<SecureStorageManager>();
  await _secure.setToken(
      value:
          'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsid2ViIl0sInVzZXJfaWQiOiJ4Y3ZjdmJ2di1iYTVkLTRiOTItODViZS1kZmdkZmdkZmdkZmciLCJ1c2VyX25hbWUiOiJhZG1pbi5hZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE2NzgyMDg3ODcsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6InFSMV9OZHJiX1hCVWhWR3pKQm1FSEcxTjVqbyIsImNsaWVudF9pZCI6IjkzZWQ0NTNlLWI3YWMtNDE5Mi1hNmQ0LWM0NWZhZTBkOTlhYyJ9.xeJijVFTsxAbe7BtCE5Nj9bPXAicl67Y0xw9-4UKmLi1kW6TFqUYFBz_kVhnJcn9qt4K-LpsNHEMfi47OUc7XOBu02eVV6_1RoSX3uOxqqPw7G-Lx8-s9DWJ6oVs7YwuTJS5yYWxq7SgJLFheGtXl6j5Zw3EbqX2Fb6Fj-yfc_wB0aXNHkrXAW5oV4lY4lxRwOSY_6DXRuI4e3KLC6Y80wuu6aSgus0BtpjCVcDsfUA4DL_dRtYOZhFk3WS5AqK6rp-Dr8TqUhiRd1n64opPdV_QtgA3HQdvQvx48CPSUJZ6rAOdclUnVweDQaBAevoGJIpbF0PC27ItqhOCZAHbtw');
  final _token = await _secure.getToken();
  return (_token ?? '').isNotEmpty;
}
