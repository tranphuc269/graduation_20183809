import 'package:flutter/material.dart';

import '../../core/app/app_constant.dart';

class DefaultTextField extends StatelessWidget {
  const DefaultTextField({
    required this.controller,
    this.hintText,
    this.icon,
    this.keyboardType,
    this.obscureText,
    Key? key,
  }) : super(key: key);
  final String? hintText;
  final IconData? icon;
  final TextInputType? keyboardType;
  final bool? obscureText;
  final TextEditingController controller;

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      decoration: const BoxDecoration(
        borderRadius: BorderRadius.all(Radius.circular(kShape)),
        color: kAccentColor,
      ),
      child: TextField(
        controller: controller,
        cursorColor: kPrimaryColor,
        textInputAction: TextInputAction.next,
        keyboardType: keyboardType,
        obscureText: obscureText ?? false,
        decoration: InputDecoration(
          border: InputBorder.none,
          icon: Icon(icon, color: kPrimaryColor),
          hintText: hintText,
        ),
      ),
    );
  }
}
