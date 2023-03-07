class ApiResponse<T> {

  ApiResponse({required this.success, required this.error, this.data});

  factory ApiResponse.fromJson(Map<dynamic, dynamic> json) {
    return ApiResponse(
      success: json['success'],
      error: json['error'],
      data: json['data'],
    );
  }

  bool success;
  String error;
  T? data;
}