import 'package:flutter/material.dart';

import '../../core/app/app_constant.dart';
import '../../data/models/response/notification/notification_response.dart';

class NotificationTiles extends StatelessWidget {
  const NotificationTiles({
    required this.data,
    Key? key,
  }) : super(key: key);
  final NotificationData data;

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: Container(
          height: 50,
          width: 50,
          decoration: const BoxDecoration(
              image: DecorationImage(
                  image: AssetImage('assets/images/shopping_bag.png'),
                  fit: BoxFit.cover))),
      title: const Text('Đơn hàng', style: TextStyle(color: kDarkColor)),
      subtitle: Text(data.content, style: const TextStyle(color: kLightColor)),
      onTap: () {
        // onTap.call();
      },
      enabled: data.enable(),
    );
  }
}
