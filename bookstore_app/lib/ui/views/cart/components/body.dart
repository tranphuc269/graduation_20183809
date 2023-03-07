import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:get/get.dart';

import '../../../../core/app/size_config.dart';
import '../controller/cart_controller.dart';
import 'cart_card.dart';

class CartBody extends StatefulWidget {
  @override
  _CartBodyState createState() => _CartBodyState();
}

class _CartBodyState extends State<CartBody> {
  final cartController = Get.find<CartController>();

  @override
  Widget build(BuildContext context) {
    return Padding(
        padding:
            EdgeInsets.symmetric(horizontal: getProportionateScreenWidth(20)),
        child: Column(
          children: List.generate(
            cartController.cartData.value?.data.length ?? 0,
            (index) => Padding(
              padding: const EdgeInsets.symmetric(vertical: 10),
              child: Dismissible(
                key: Key(cartController.cartData.value!.data[index].cartItemId
                    .toString()),
                direction: DismissDirection.endToStart,
                onDismissed: (direction) {
                  cartController.deleteItem(
                      cartItemId: cartController
                          .cartData.value!.data[index].cartItemId);
                },
                background: Container(
                  padding: const EdgeInsets.symmetric(horizontal: 20),
                  decoration: BoxDecoration(
                    color: const Color(0xFFFFE6E6),
                    borderRadius: BorderRadius.circular(15),
                  ),
                  child: Row(
                    children: [
                      const Spacer(),
                      SvgPicture.asset('assets/icons/Trash.svg'),
                    ],
                  ),
                ),
                child:
                    CartCard(cart: cartController.cartData.value!.data[index]),
              ),
            ),
          ),
        )
        // child: ListView.builder(
        //   itemCount: demoCarts.length,
        //   itemBuilder: (context, index) => ,
        // ),
        );
  }
}
