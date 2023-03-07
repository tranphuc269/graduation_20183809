import 'package:flutter/material.dart';

class KeyboardDismissed extends StatelessWidget {
  const KeyboardDismissed({required this.child, Key? key}) : super(key: key);

  final Widget child;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => FocusScope.of(context).focusedChild?.unfocus(),
      child: child,
    );
  }
}
