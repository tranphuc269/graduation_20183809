import '../../../models/response/user/user.dart';
import '../../../models/response/user/user_login_response.dart';

abstract class AuthApi {
  Future<User> verifyToken({
    required int userId,
    required String token,
  });

  Future<UserLoginResponse> login({
    required String userName,
    required String password,
  });
}