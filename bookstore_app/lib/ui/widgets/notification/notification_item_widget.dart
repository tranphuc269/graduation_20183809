import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../../../core/app/app_constant.dart';
import '../../../core/themes/app_style.dart';
import '../../../data/dummy/product_dummy.dart';
import '../cached_image.dart';

class NotificationItemWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      margin: const EdgeInsets.only(bottom: AppConst.defaultMediumMargin),
      width: MediaQuery.of(context).size.width,
      child: Row(
        children: [
          Container(
            padding: const EdgeInsets.only(right: AppConst.defaultMediumMargin),
            width: 86,
            child: CachedImage(
              url: ProductDummy.products[0],
              borderRadius: BorderRadius.circular(8),
            ),
          ),
          Expanded(
            child: SizedBox(
              height: 102,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    'Đơn hàng tại Happy Lunch - Ngõ Hàm Long 2 đã hoàn tất',
                    style: AppStyle.normalSmall
                        .copyWith(fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: AppConst.defaultVerySmallMargin,),
                  Text(
                    'Cảm ơn bạn đã sử dụng dịch vụ ShopeeFood. Hãy chia sẻ cảm nhận của bạn về đơn hàng để giúp những khách hàng khác có thể tham khảo nhé',
                    style: AppStyle.normalSmall.copyWith(
                        color: const Color(0xFF323232).withOpacity(0.54)),
                  ),
                  const SizedBox(height: AppConst.defaultVerySmallMargin,),
                  Text(
                    '21/10/2022 12:11',
                    style: AppStyle.normalSmall.copyWith(
                        color: const Color(0xFF323232).withOpacity(0.54)),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
