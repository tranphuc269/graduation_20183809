import 'package:get/get.dart';

import '../../../core/base/base_controller.dart';
import '../../../data/models/response/notification/notification_response.dart';
import '../../../data/sources/server/notification/notification_service.dart';

class NotificationController extends BaseController {
  NotificationController({required this.notificationService});

  final INotificationService notificationService;

  final notifications = List<NotificationData>.empty(growable: true).obs;

  @override
  Future<void> onInit() async {
    isLoading(true);

    await _getNotification();
    super.onInit();

    isLoading(false);
  }

  Future<void> _getNotification() async {
    notifications
      ..clear()
      ..addAll(
          (await notificationService.getMyNotification(page: 0, perPage: 20))
              .data);
  }
}
