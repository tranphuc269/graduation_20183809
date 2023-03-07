import 'package:flutter/material.dart';

import '../../../../core/app/app_constant.dart';

class PaymentHeaderLabel extends StatelessWidget {
  final String headerText;

  const PaymentHeaderLabel({
    required this.headerText,
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(kDefaultPadding),
      child: Text(
        headerText,
        style: const TextStyle(color: kLightColor, fontSize: 28.0),
      ),
    );
  }
}
