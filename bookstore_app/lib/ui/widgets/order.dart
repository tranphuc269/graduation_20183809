import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../core/app/app_constant.dart';
import '../../core/themes/app_colors.dart';
import '../../data/models/response/order/order_history_list_response.dart';
import '../views/profile/screens/order_history/order_detail/order_detail_view.dart';

class OrderListHistory extends StatelessWidget {
  const OrderListHistory({required this.data});

  final OrderHistoryListData data;

  @override
  Widget build(BuildContext context) {
    return Container(
        padding: const EdgeInsets.all(AppConst.defaultSmallMargin),
        child: Container(
          decoration: BoxDecoration(
            boxShadow: [
              BoxShadow(
                color: AppColors.subtitleText.withOpacity(0.3),
                blurRadius: AppConst.defaultSmallMargin,
              )
            ],
            borderRadius: BorderRadius.circular(AppConst.defaultSmallMargin),
            color: AppColors.white,
          ),
          child: Padding(
            padding: const EdgeInsets.all(kDefaultPadding),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    RichText(
                        text: TextSpan(children: <TextSpan>[
                      const TextSpan(
                        text: 'Order: ',
                        style: TextStyle(
                            fontWeight: FontWeight.normal, color: kDarkColor),
                      ),
                      TextSpan(
                        text: '#' '${data.getShortOrderId()}',
                        style: const TextStyle(
                            fontWeight: FontWeight.normal, color: kDarkColor),
                      ),
                    ])),
                    Text(
                      data.getCreatedDate(),
                      style: const TextStyle(fontWeight: FontWeight.normal),
                    ),
                  ],
                ),
                const SizedBox(
                  height: kLessPadding,
                ),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Row(
                      children: <Widget>[
                        const Text('Mã trạng thái: ',
                            style: TextStyle(fontWeight: FontWeight.normal)),
                        Padding(
                          padding: const EdgeInsets.only(left: kLessPadding),
                          child: Text(' ${data.getTrackingOrderId()}',
                              style: const TextStyle(
                                  fontWeight: FontWeight.normal)),
                        ),
                      ],
                    ),
                    const SizedBox(
                      height: kLessPadding,
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                        Row(
                          children: <Widget>[
                            const Text('SL: ',
                                style:
                                    TextStyle(fontWeight: FontWeight.normal)),
                            Padding(
                              padding:
                                  const EdgeInsets.only(left: kLessPadding),
                              child: Text(data.getTotalItem(),
                                  style: const TextStyle(
                                      fontWeight: FontWeight.normal)),
                            ),
                          ],
                        ),
                        Row(
                          children: <Widget>[
                            const Text('Tổng: ',
                                style:
                                    TextStyle(fontWeight: FontWeight.normal)),
                            Padding(
                              padding:
                                  const EdgeInsets.only(left: kLessPadding),
                              child: Text(data.getTotalPrice(),
                                  //total amount
                                  style: const TextStyle(
                                      fontWeight: FontWeight.bold)),
                            ),
                          ],
                        )
                      ],
                    )
                  ],
                ),
                const SizedBox(
                  height: kLessPadding,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    MaterialButton(
                      padding: const EdgeInsets.only(
                          left: 24, right: 24, top: 10, bottom: 10),
                      color: AppColors.white,
                      onPressed: () {
                        Get.toNamed(OrderHistoryView.routeName,
                            arguments: data.orderId);
                      },
                      shape: RoundedRectangleBorder(
                        borderRadius:
                            BorderRadius.circular(AppConst.defaultSmallMargin),
                        side: const BorderSide(color: kDarkColor, width: 2),
                      ),
                      child: const Text(
                        'Chi tiết',
                        style: TextStyle(fontWeight: FontWeight.normal),
                      ),
                    ),
                    Text(
                      data.orderStatus,
                      style: const TextStyle(
                          fontWeight: FontWeight.bold, color: kPrimaryColor),
                    ),
                  ],
                )
              ],
            ),
          ),
        ));
  }

  String getOrderStatusString() {
    final str = 'New';
    // switch (order.orderStatus) {
    //   case UserOrderStatus.Paid:
    //     str = 'Paid';
    //     break;
    //   case UserOrderStatus.Sent:
    //     str = 'Sent';
    //     break;
    //   case UserOrderStatus.Delivered:
    //     str = 'Delivered';
    //     break;
    //   case UserOrderStatus.New:
    //   default:
    //     break;
    // }
    return str;
  }
}
