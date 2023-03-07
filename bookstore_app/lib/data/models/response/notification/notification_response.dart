import '../base_response.dart';

class NotificationResponse extends BaseResponse {
  NotificationResponse({required this.data, required super.meta});

  factory NotificationResponse.fromJson(Map<String, dynamic> json) {
    return NotificationResponse(
      data: (json['data'] as List)
          .map((e) => NotificationData.fromJson(e))
          .toList(),
      meta: MetaStatus.fromJson(
        json['meta'],
      ),
    );
  }

  List<NotificationData> data;
}

class NotificationData {
  NotificationData(
      {required this.content,
      required this.notificationId,
      required this.read,
      required this.sourceId,
      required this.sourceType});

  factory NotificationData.fromJson(Map<String, dynamic> json) {
    return NotificationData(
      content: json['content'],
      notificationId: json['notificationId'],
      read: json['read'],
      sourceId: json['sourceId'],
      sourceType: json['sourceType'],
    );
  }

  bool enable() {
    return read == 1;
  }

  String notificationId;
  String sourceId;
  String sourceType;
  int read;
  String content;
}
