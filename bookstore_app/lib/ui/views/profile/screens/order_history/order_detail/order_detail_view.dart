import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:im_stepper/stepper.dart';

import '../../../../../../core/app/app_constant.dart';
import '../../../../../../core/base/stateless_view_base.dart';
import '../../../../../widgets/base/base_appbar.dart';
import '../../../../../widgets/base/base_view.dart';
import 'order_detail_controller.dart';

class TrackOrderModal {
  TrackOrderModal(
      {required this.icon,
      required this.title,
      required this.subtitle,
      required this.time});

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['icon'] = this.icon;
    data['title'] = this.title;
    data['subtitle'] = this.subtitle;
    data['time'] = this.time;
    return data;
  }

  IconData icon;
  String title;
  String subtitle;
  String time;
}

final trackOrderList = [
  TrackOrderModal(
      icon: Icons.card_travel,
      title: 'Tạo đơn hàng',
      subtitle: 'Cập nhật',
      time: '08.00'),
  TrackOrderModal(
      icon: Icons.person,
      title: 'Xử lý đơn hàng',
      subtitle: 'Chúng tôi đang chuẩn bị đơn đặt hàng của bạn',
      time: '09.50'),
  TrackOrderModal(
      icon: Icons.payment,
      title: 'Thanh toán được xác nhận',
      subtitle: 'Đang chờ xác nhận',
      time: '11.30'),
  TrackOrderModal(
      icon: Icons.receipt,
      title: 'Đơn hàng đã được giao',
      subtitle: 'Đã nhận được hàng',
      time: '02.15'),
];

class OrderHistoryView extends StateLessViewBase<OrderDetailController> {
  static const routeName = '/order_detail_history';

  @override
  Widget buildBody(BuildContext context) {
    // TODO: implement buildBody
    return Obx(
      () => BaseView(
          loadingEnabled: viewModel.isLoading.value,
          errorEnabled: viewModel.isError.value,
          onRetry: viewModel.onInit,
          child: viewModel.orderDetailData.value == null
              ? const SizedBox()
              : Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Padding(
                      padding: const EdgeInsets.symmetric(
                          horizontal: 16, vertical: kDefaultPadding),
                      child: Text(
                        viewModel.orderDetailData.value!.getUpdatedAt(),
                        style: const TextStyle(
                            fontSize: 16,
                            color: kLightColor,
                            fontWeight: FontWeight.bold),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 16),
                      child: Text(
                        'Mã đơn hàng: ${viewModel.orderDetailData.value!.getOrderId()}',
                        style: const TextStyle(
                            fontSize: 16,
                            color: kLightColor,
                            fontWeight: FontWeight.bold),
                      ),
                    ),
                    const Padding(
                      padding: EdgeInsets.only(
                        left: 16,
                        right: 16,
                        top: 16,
                      ),
                      child: Text(
                        'Đơn hàng',
                        style: TextStyle(
                          fontSize: 22,
                        ),
                      ),
                    ),
                    Row(
                      children: [
                        SizedBox(
                          height: MediaQuery.of(context).size.height / 2,
                          width: MediaQuery.of(context).size.width / 6,
                          child: IconStepper(
                            direction: Axis.vertical,
                            enableNextPreviousButtons: false,
                            enableStepTapping: false,
                            stepColor: Colors.green,
                            activeStepBorderColor: kWhiteColor,
                            activeStepBorderWidth: 0,
                            activeStepBorderPadding: 0,
                            lineColor: Colors.green,
                            lineLength: 70,
                            lineDotRadius: 2,
                            stepRadius: 16,
                            icons: const [
                              Icon(Icons.radio_button_checked,
                                  color: Colors.green),
                              Icon(Icons.check, color: kWhiteColor),
                              Icon(Icons.check, color: kWhiteColor),
                              Icon(Icons.check, color: kWhiteColor),
                            ],
                          ),
                        ),
                        Expanded(
                          child: ListView.builder(
                            shrinkWrap: true,
                            padding: EdgeInsets.zero,
                            itemCount: trackOrderList.length,
                            itemBuilder: (context, index) {
                              return Row(
                                children: [
                                  SizedBox(
                                    width:
                                        MediaQuery.of(context).size.width / 1.5,
                                    child: ListTile(
                                      contentPadding:
                                          const EdgeInsets.symmetric(
                                              vertical: 16),
                                      leading: Icon(
                                        trackOrderList[index].icon,
                                        size: 30,
                                        color: kPrimaryColor,
                                      ),
                                      title: Text(
                                        trackOrderList[index].title,
                                        style: const TextStyle(fontSize: 18),
                                      ),
                                      subtitle: Text(
                                        trackOrderList[index].subtitle,
                                        style: const TextStyle(fontSize: 16),
                                      ),
                                    ),
                                  ),
                                  Text(
                                    trackOrderList[index].time,
                                    style: const TextStyle(fontSize: 18),
                                  ),
                                ],
                              );
                            },
                          ),
                        ),
                      ],
                    ),
                    Container(
                      margin: const EdgeInsets.symmetric(horizontal: 16),
                      padding:
                          const EdgeInsets.only(left: 24, top: 16, bottom: 16),
                      decoration: BoxDecoration(
                        color: kWhiteColor,
                        border: Border.all(
                          width: 0.5,
                          color: kLightColor,
                        ),
                        borderRadius: BorderRadius.circular(8),
                      ),
                      child: Row(
                        children: [
                          const Icon(Icons.home,
                              size: 40, color: kPrimaryColor),
                          const SizedBox(width: 32),
                          Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              const Text(
                                'Địa chỉ giao hàng',
                                style: TextStyle(fontSize: 20),
                              ),
                              Text(
                                'Nhà, công sở',
                                style: TextStyle(
                                  fontSize: 16,
                                  color: kDarkColor.withOpacity(0.7),
                                ),
                              ),
                              SizedBox(
                                width: MediaQuery.of(context).size.width / 1.8,
                                child: Text(
                                  'Địa chỉ : ${viewModel.orderDetailData.value!.shippingAddress.getAddress()}',
                                  style: TextStyle(
                                    fontSize: 15,
                                    color: kDarkColor.withOpacity(0.5),
                                  ),
                                ),
                              ),
                              SizedBox(
                                width: MediaQuery.of(context).size.width / 1.8,
                                child: Text(
                                  'SĐT : ${viewModel.orderDetailData.value!.shippingAddress.getPhoneNumber()}',
                                  style: TextStyle(
                                    fontSize: 15,
                                    color: kDarkColor.withOpacity(0.5),
                                  ),
                                ),
                              ),
                              SizedBox(
                                width: MediaQuery.of(context).size.width / 1.8,
                                child: Text(
                                  'Người nhận : ${viewModel.orderDetailData.value!.shippingAddress.getName()}',
                                  style: TextStyle(
                                    fontSize: 15,
                                    color: kDarkColor.withOpacity(0.5),
                                  ),
                                ),
                              ),
                            ],
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
          isConnectNetwork: viewModel.isConnectNetwork.value),
    );
  }

  @override
  PreferredSizeWidget? buildAppBar(BuildContext context) {
    // TODO: implement buildAppBar
    return AppBarTitle(title: 'Đơn hàng');
  }
}
