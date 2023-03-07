import 'package:flutter/material.dart';

import '../../../../core/app/app_constant.dart';
import '../../../../core/themes/app_colors.dart';

class PaymentDefaultButton extends StatelessWidget {
  const PaymentDefaultButton({
    required this.btnText,
    required this.onPressed,
    Key? key,
  }) : super(key: key);
  final String btnText;
  final Function() onPressed;

  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery.of(context).size.width,
      margin: const EdgeInsets.symmetric(vertical: kDefaultPadding),
      padding: const EdgeInsets.symmetric(
          horizontal: kDefaultPadding, vertical: kLessPadding),
      child: TextButton(
        style: flatButtonStyle,
        onPressed: onPressed,
        child: Text(
          btnText.toUpperCase(),
          style: const TextStyle(
              color: AppColors.white,
              fontSize: 18,
              fontWeight: FontWeight.w500),
        ),
      ),
    );
  }
}
