
import '../../data/models/response/user/user.dart';

enum AppType { INITIAL, FIRST_INSTALL, UNAUTHENTICATED, AUTHENTICATED }

class AuthState {

  const AuthState({this.user, this.appStatus = AppType.INITIAL});
  final User? user;
  final AppType appStatus;

  AuthState copyWith({
    User? user,
    AppType? appStatus,
  }) {
    return AuthState(
      user: user ?? this.user,
      appStatus: appStatus ?? this.appStatus,
    );
  }
}