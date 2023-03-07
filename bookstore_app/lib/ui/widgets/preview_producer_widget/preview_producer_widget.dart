import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../../../core/app/app_constant.dart';
import '../../../core/themes/app_style.dart';
import '../../../data/models/response/producer/producer_data.dart';
import '../cached_image.dart';

class PreviewProducerWidget extends StatelessWidget {
  const PreviewProducerWidget({required this.data});

  final ProducerData data;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      margin: const EdgeInsets.only(right: AppConst.defaultMediumMargin),
      width: MediaQuery.of(context).size.width * 0.8,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          SizedBox(
            height: 160,
            width: MediaQuery.of(context).size.width * 0.8,
            child: CachedImage(
              url: data.img,
              borderRadius: BorderRadius.circular(16),
            ),
          ),
          const SizedBox(
            height: AppConst.defaultMediumMargin,
          ),
          Padding(
            padding: AppConst.kPaddingSmallDefaultHorizontal,
            child: Text(
              data.producerName,
              style: AppStyle.subtitle18,
              maxLines: 1,
            ),
          )
        ],
      ),
    );
  }
}
