class UserLoginResponse {
  UserLoginResponse(
      {required this.access_token,
      required this.expires_in,
      required this.refresh_token,
      required this.scope,
      required this.token_type});

  factory UserLoginResponse.fromJson(Map<String, dynamic> json) {
    return UserLoginResponse(
      access_token: json['access_token'],
      expires_in: json['expires_in'],
      refresh_token: json['refresh_token'],
      scope: json['scope'],
      token_type: json['token_type'],
    );
  }

  String access_token;
  String token_type;
  String refresh_token;
  int expires_in;
  String scope;
}
