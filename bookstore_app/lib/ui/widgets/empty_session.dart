import 'package:flutter/material.dart';

import '../../core/app/app_constant.dart';

class EmptySection extends StatelessWidget {
  final String emptyImg, emptyMsg;

  const EmptySection({
    required this.emptyImg,
    required this.emptyMsg,
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Image(
            image: AssetImage(emptyImg),
            height: 150.0,
          ),
          Padding(
            padding: const EdgeInsets.only(top: kLessPadding),
            child: Text(
              emptyMsg,
              style: kDarkTextStyle,
            ),
          ),
        ],
      ),
    );
  }
}
