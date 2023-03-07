import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../../../core/localization/language_const.dart';
import '../../../core/themes/app_style.dart';

class PaginationMaxItemView extends StatelessWidget {
  const PaginationMaxItemView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const SizedBox(height: 12),
        Text(
          International.maxItem.tr,
          style: AppStyle.subtitle16.copyWith(
            color: Colors.grey,
            fontWeight: FontWeight.w600,
          ),
        ),
        const SizedBox(height: 24),
      ],
    );
  }
}