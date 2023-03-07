import 'package:flutter/material.dart';

import '../../../core/app/app_constant.dart';
import '../../../core/themes/app_style.dart';

class ProfileItemWidget extends StatelessWidget {
  const ProfileItemWidget(
      {required this.title,
      required this.onTab,
      required this.imgSource,
      required this.icForward});

  final String imgSource;
  final String title;
  final Function() onTab;
  final bool icForward;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return GestureDetector(
      child: Container(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Row(
              children: [
                Image.asset(
                  imgSource,
                  width: 26,
                  color: const Color(0xFF38972E),
                ),
                const SizedBox(
                  width: AppConst.defaultMediumMargin,
                ),
                Text(
                  title,
                  style: AppStyle.subtitle18,
                ),
              ],
            ),
            icForward
                ? const Icon(Icons.arrow_forward_ios_outlined)
                : const SizedBox(),
          ],
        ),
        margin:
            const EdgeInsets.only(bottom: AppConst.defaultMediumMargin * 1.5),
      ),
      onTap: onTab,
    );
  }
}
