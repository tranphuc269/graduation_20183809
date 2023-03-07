import 'package:flutter/material.dart';
import '../../../core/app/app_constant.dart';
import '../../widgets/empty_session.dart';
import '../../widgets/sub_title.dart';
import 'component/payment_default_button.dart';

class PaymentSuccess extends StatelessWidget {
  static const routeName = '/payment_success';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: kWhiteColor,
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const EmptySection(
            emptyImg: success,
            emptyMsg: 'Thành công !!',
          ),
          const SubTitle(
            subTitleText: 'Thanh toán của bạn đã được thực hiện thành công',
          ),
          PaymentDefaultButton(
            btnText: 'Mua sắm',
            onPressed: () {
              while(Navigator.canPop(context)){
                Navigator.pop(context);
              }
            },
          ),
        ],
      ),
    );
  }
}
