import 'package:get/get.dart';


class NotificationHandler {
  NotificationHandler({
    required this.data,
    this.title,
    this.body,
  });

  String? title;
  String? body;
  Map<String, dynamic>? data;

  String pageDirection() {
    return pageDirectionFromNotification(subject, subjectId);
  }

  String get subject => data!['subject'];

  String get bodyHtml => data!['body_html'];

  int? get isDiscussion =>
      data!['is_discussion'] != null ? int.parse(data!['is_discussion']) : null;

  int? get subjectId =>
      data!['subject_id'] != null ? int.parse(data!['subject_id']) : null;

  void redirectNotifToPage() {
    Get.toNamed(pageDirection());
  }
}

String pageDirectionFromNotification(String type, int? id) {
  return '';
  switch (type) {
    // case '*':
    //   return MainNavView.route;
    // default:
    //   return MainNavView.route;
  }
}
