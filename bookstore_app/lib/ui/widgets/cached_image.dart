import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';

import 'common_widget.dart';

class CachedImage extends StatelessWidget {
  const CachedImage({
    required this.url,
    Key? key,
    this.borderRadius,
    this.fit,
  }) : super(key: key);

  final String url;
  final BorderRadius? borderRadius;
  final BoxFit? fit;

  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: borderRadius ?? BorderRadius.circular(30),
      child: CachedNetworkImage(
        imageUrl: url,
        placeholder: (context, url) => platformLoadingIndicator(),
        errorWidget: (context, url, error) => const Icon(Icons.error),
        fit: fit ?? BoxFit.cover,
        // width: size?.width,
        // height: size?.height,
      ),
    );
  }
}
