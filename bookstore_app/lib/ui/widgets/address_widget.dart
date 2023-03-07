import 'package:flutter/material.dart';

import '../../core/themes/app_colors.dart';
import '../../core/themes/app_style.dart';
import 'base_button.dart';

class AddressWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      margin: const EdgeInsets.fromLTRB(20, 0, 20, 16),
      padding: const EdgeInsets.only(bottom: 16),
      decoration: const BoxDecoration(
          border: Border(
              bottom: BorderSide(color: AppColors.systemDarkGrey, width: 0.5))),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                'Andy Andrew',
                style:
                    AppStyle.subtitle18.copyWith(fontWeight: FontWeight.bold),
              ),
              Container(
                decoration: BoxDecoration(
                    border: Border.all(color: AppColors.systemDarkGrey),
                    shape: BoxShape.circle),
                width: 24,
                height: 24,
              )
            ],
          ),
          const SizedBox(
            height: 4,
          ),
          Text(
            '+1 3712 3789',
            style: AppStyle.subtitle16,
          ),
          const SizedBox(
            height: 4,
          ),
          Text(
            '711 Leavenworth Apt. # 47 San Francisco, CA 94109',
            style: AppStyle.subtitle16,
          ),
          const SizedBox(
            height: 8,
          ),
          Row(
            children: [
              Expanded(
                child: BaseButton(
                  text: 'Change Address',
                  height: 46,
                  borderRadius: 26,
                  textColor: AppColors.systemBlack,
                  fontWeight: FontWeight.bold,
                  elevation: 0,
                  onPressed: () {},
                  borderColor: const Color(0xFF1630C1),
                  color: Colors.white,
                ),
                flex: 3,
              ),
              Expanded(
                child: Container(),
                flex: 2,
              )
            ],
          )
        ],
      ),
    );
  }
}
