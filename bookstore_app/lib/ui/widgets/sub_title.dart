import 'package:flutter/material.dart';

import '../../core/app/app_constant.dart';

class SubTitle extends StatelessWidget {

  const SubTitle({
    required this.subTitleText,
    Key? key,
  }) : super(key: key);
  final String subTitleText;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(
          horizontal: kDefaultPadding, vertical: kFixPadding),
      child: Text(
        subTitleText,
        textAlign: TextAlign.center,
        style: kSubTextStyle,
      ),
    );
  }
}
