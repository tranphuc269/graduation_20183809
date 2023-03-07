import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../screens/order_history/order_list_history/order_list_history_view.dart';
import 'profile_menu.dart';
import 'profile_pic.dart';

class Body extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.symmetric(vertical: 20),
      child: Column(
        children: [
          const ProfilePic(),
          const SizedBox(height: 20),
          ProfileMenu(
            text: 'Tài khoản',
            icon: 'assets/icons/User Icon.svg',
            press: () => {},
          ),
          ProfileMenu(
            text: 'Thông báo',
            icon: 'assets/icons/Bell.svg',
            press: () {},
          ),
          ProfileMenu(
            text: 'Cài đặt',
            icon: 'assets/icons/Settings.svg',
            press: () {},
          ),
          ProfileMenu(
            text: 'Trung tâm hỗ trợ',
            icon: 'assets/icons/Question mark.svg',
            press: () {},
          ),
          ProfileMenu(
            text: 'Đơn hàng',
            icon: 'assets/icons/order-delivery.svg',
            press: () {
              Get.toNamed(OrderListHistoryView.routeName);
            },
          ),
          ProfileMenu(
            text: 'Đăng xuất',
            icon: 'assets/icons/Log out.svg',
            press: () {},
          ),
        ],
      ),
    );
  }
}
