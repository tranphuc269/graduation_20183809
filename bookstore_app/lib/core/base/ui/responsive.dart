import 'package:flutter/material.dart';

class Responsive extends StatelessWidget {
  const Responsive({
    required this.mobile,
    required this.tablet,
    Key? key,
  }) : super(key: key);
  final Widget mobile;
  final Widget tablet;

  static bool isMobile(BuildContext context) =>
      MediaQuery.of(context).size.width < 650;

  static bool isTablet(BuildContext context) =>
      MediaQuery.of(context).size.width < 1100 &&
      MediaQuery.of(context).size.width >= 650;

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (context, constraints) {
        // if (constraints.maxWidth >= 1100) {
        //   return desktop;
        // }
        if (MediaQuery.of(context).size.width >= 650) {
          return tablet;
        } else {
          return mobile;
        }
      },
    );
  }
}
