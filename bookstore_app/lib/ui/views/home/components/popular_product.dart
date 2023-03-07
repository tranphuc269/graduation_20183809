import 'package:flutter/material.dart';
import '../../../../core/app/size_config.dart';
import '../../../../core/base/element_view_base.dart';

import '../../../widgets/product_card.dart';
import '../controller/home_controller.dart';
import 'section_title.dart';

class PopularProducts extends ElementViewBase<HomeController> {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding:
              EdgeInsets.symmetric(horizontal: getProportionateScreenWidth(20)),
          child: SectionTitle(title: 'Sản phẩm phổ biến', press: () {}),
        ),
        SizedBox(height: getProportionateScreenWidth(20)),
        SingleChildScrollView(
          scrollDirection: Axis.horizontal,
          child: Row(
            children: [
              ...List.generate(
                viewModel.products.length,
                (index) {
                  // if (demoProducts[0].isPopular)
                    return ProductCard(product:  viewModel.products[index]);

                  return const SizedBox.shrink();
                },
              ),
              SizedBox(width: getProportionateScreenWidth(20)),
            ],
          ),
        )
      ],
    );
  }
}
