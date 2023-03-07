import 'dart:convert';
import 'dart:developer';
import 'dart:io';

import 'package:dio/dio.dart';
import 'package:http/http.dart' as http;
import '../../../../core/app/app_env.dart';
import '../../../../core/database/secure_storage/secure_storage_manager.dart';
import '../../../../core/network/api_request.dart';
import '../../../../core/network/api_response.dart';
import '../../../../core/network/api_url.dart';
import '../../../models/response/user/user.dart';
import '../../../models/response/user/user_login_response.dart';
import 'auth_api.dart';

class AuthApiImpl implements AuthApi {
  String tag = 'Auth Api';

  @override
  Future<UserLoginResponse> login({
    required String userName,
    required String password,
  }) async {
    try {
      final headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Authorization':
            'Basic OTNlZDQ1M2UtYjdhYy00MTkyLWE2ZDQtYzQ1ZmFlMGQ5OWFjOmNsaWVudC5kZXZkMTIz'
      };
      final request = http.Request(
          'POST', Uri.parse(AppEnv.find.appConfig.baseUrl + ApiUrl.login));
      request.bodyFields = {
        'grant_type': 'password',
        'username': userName,
        'password': password
      };
      request.headers.addAll(headers);

      final http.StreamedResponse response = await request.send();
      return UserLoginResponse.fromJson(
          jsonDecode(await response.stream.bytesToString()));
    } catch (e) {
      log('$tag Error = $e');
      rethrow;
    }
  }

  @override
  Future<User> verifyToken({
    required int userId,
    required String token,
  }) async {
    try {
      final String? token = await SecureStorageManager.find.getToken();
      String url = AppEnv.find.get.baseUrl;
      url += ApiUrl.verifyToken;
      final response = await Dio().get(
        url,
        options: Options(
          headers: {
            HttpHeaders.authorizationHeader: 'Bearer $token',
            'Accept': Headers.jsonContentType,
            'Client-Token': AppEnv.find.get.clientToken,
          },
          contentType: Headers.jsonContentType,
        ),
      );
      return User.fromJson(ApiResponse.fromJson(response.data).data);
    } catch (e) {
      log('$tag Error = $e');
      rethrow;
    }
  }
}
