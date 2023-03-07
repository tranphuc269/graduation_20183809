import '../../../models/response/notification/notification_response.dart';

abstract class INotificationService {
  Future<NotificationResponse> getMyNotification(
      {required int page, required int perPage});

  Future<void> readNotification({required String notificationId});
}
