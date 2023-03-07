import 'package:flutter/material.dart';

import '../../core/app/app_constant.dart';

class OpenFlutterBlockHeader extends StatelessWidget {

  const OpenFlutterBlockHeader(
      {required this.width,
      required this.title,
      this.linkText,
      this.onLinkTap,
      this.description});
  final double width;
  final String title;
  final String? linkText;
  final VoidCallback? onLinkTap;
  final String? description;

  @override
  Widget build(BuildContext context) {
    final _theme = Theme.of(context);
    const rightLinkWidth = 100.0;
    return InkWell(
      onTap: onLinkTap,
      child: Container(
        padding: const EdgeInsets.only(top: kFixPadding, left: kFixPadding),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Row(
              children: <Widget>[
                SizedBox(
                  width: width - rightLinkWidth,
                  child: Text(title, style: _theme.textTheme.caption),
                ),
                linkText != null
                    ? SizedBox(
                        width: rightLinkWidth,
                        child: Align(
                          alignment: Alignment.centerRight,
                          child: Text(linkText!,
                              style: _theme.textTheme.bodyText2),
                        ),
                      )
                    : Container(),
              ],
            ),
            description != null
                ? Text(
                    description!,
                    style: _theme.textTheme.bodyText2,
                  )
                : Container()
          ],
        ),
      ),
    );
  }
}
