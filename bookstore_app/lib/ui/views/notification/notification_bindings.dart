import 'package:get/get.dart';

import '../../../data/sources/server/notification/notification_service_impl.dart';
import 'notification_controller.dart';

class NotificationBinding extends Bindings {
  @override
  void dependencies() {
    // TODO: implement dependencies
    Get.lazyPut(
      () => NotificationController(
        notificationService: Get.find<NotificationServiceImpl>(),
      ),
    );
  }
}
