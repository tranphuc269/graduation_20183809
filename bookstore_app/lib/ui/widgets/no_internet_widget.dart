import 'package:flutter/cupertino.dart';

import '../../core/app/app_constant.dart';
import '../../core/themes/app_style.dart';
import 'base_button.dart';

class NoInternetWidget extends StatelessWidget {
  const NoInternetWidget({required this.onPress});

  final Function() onPress;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        const SizedBox(height: 200,),
        Image.asset('assets/images/no_internet.png', width: 180,),
        const SizedBox(
          height: AppConst.defaultMediumMargin,
        ),
        Text(
          'Oops! No Internet',
          style: AppStyle.subtitle24,
        ),
        const SizedBox(
          height: AppConst.defaultSmallMargin,
        ),
        Padding(
          padding: AppConst.kPaddingLargeDefaultHorizontal,
          child: Text(
            'Check your internet connection and then retry to connect.',
            style: AppStyle.subtitle16,
            textAlign: TextAlign.center,
          ),
        ),
        const SizedBox(
          height: AppConst.defaultMediumMargin,
        ),
        BaseButton(text: 'Retry', onPressed: onPress, margin: const EdgeInsets.symmetric(horizontal: 80),)
      ],
    );
  }
}
