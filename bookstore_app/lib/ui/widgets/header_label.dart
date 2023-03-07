import 'package:flutter/material.dart';

import '../../core/app/app_constant.dart';

class HeaderLabel extends StatelessWidget {
  const HeaderLabel({
    required this.headerText,
    Key? key,
  }) : super(key: key);
  final String headerText;

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
