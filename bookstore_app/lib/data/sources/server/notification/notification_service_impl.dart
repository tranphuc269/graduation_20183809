import '../../../../core/network/api_request.dart';
import '../../../models/response/notification/notification_response.dart';
import 'notification_service.dart';

class NotificationServiceImpl extends INotificationService {
  @override
  Future<NotificationResponse> getMyNotification(
      {required int page, required int perPage}) async{
    // TODO: implement getMyNotification
    const url = '/notification-service/notifications?page=0&per_page=10';
    // TODO: implement add to cart
    final _res = await sendRequest(
      url: url,
      requestMethod: RequestMethod.GET,
      useToken: true,
    );
    final _notice = NotificationResponse.fromJson(_res.data);
    return _notice;
  }

  @override
  Future<void> readNotification({required String notificationId}) async{
    // TODO: implement readNotification
    final url = '/notification-service/notifications/read/$notificationId';
    final _res = await sendRequest(
      url: url,
      requestMethod: RequestMethod.PATCH,
      useToken: true,
    );
  }
}
