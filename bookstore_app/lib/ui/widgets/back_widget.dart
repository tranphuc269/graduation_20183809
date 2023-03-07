import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class BackWidget extends StatelessWidget {
  const BackWidget();

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return GestureDetector(
      child: Container(
        width: 24,
        height: 24,
        color: Colors.transparent,
        child: const Icon(
          CupertinoIcons.back,
          color: Colors.black,
          size: 24,
        ),
      ),
      onTap: () {
        Navigator.of(context).pop();
      },
    );
  }
}
