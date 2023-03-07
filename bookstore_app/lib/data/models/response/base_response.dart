class BaseResponse {
  BaseResponse({required this.meta});

  MetaStatus meta;
}

class MetaStatus {
  MetaStatus({required this.code, required this.message});

  factory MetaStatus.fromJson(Map<String, dynamic> json) {
    return MetaStatus(
      code: json['code'],
      message: json['message'],
    );
  }

  int code;
  String message;
}
