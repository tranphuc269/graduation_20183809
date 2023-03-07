import 'package:flutter/material.dart';

import '../../../../core/app/app_constant.dart';
import '../../../../core/app/size_config.dart';

import '../../../../data/models/response/catalog/product/product_data.dart';
import '../../../../data/models/response/catalog/product/product_response.dart';
import '../../../widgets/cached_image.dart';

class ProductImages extends StatefulWidget {
  const ProductImages({
    Key? key,
    required this.product,
  }) : super(key: key);

  final ProductData product;

  @override
  _ProductImagesState createState() => _ProductImagesState();
}

class _ProductImagesState extends State<ProductImages> {
  int selectedImage = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        SizedBox(
          width: getProportionateScreenWidth(238),
          child: AspectRatio(
            aspectRatio: 1,
            child: Hero(
              tag: widget.product.productId.toString(),
              child: CachedImage(url: widget.product.images[selectedImage]),
            ),
          ),
        ),
        Padding(
          padding:
              EdgeInsets.symmetric(vertical: getProportionateScreenWidth(20)),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ...List.generate(widget.product.images.length,
                  (index) => buildSmallProductPreview(index)),
            ],
          ),
        ),
      ],
    );
  }

  GestureDetector buildSmallProductPreview(int index) {
    return GestureDetector(
      onTap: () {
        setState(() {
          selectedImage = index;
        });
      },
      child: AnimatedContainer(
        duration: defaultDuration,
        margin: const EdgeInsets.only(right: 15),
        padding: const EdgeInsets.all(8),
        height: getProportionateScreenWidth(48),
        width: getProportionateScreenWidth(48),
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(10),
          border: Border.all(
              color: kPrimaryColor.withOpacity(selectedImage == index ? 1 : 0)),
        ),
        child: CachedImage(
          url: widget.product.images[index],
        ),
      ),
    );
  }
}


class ProductSingleImages extends StatefulWidget {
  const ProductSingleImages({
    Key? key,
    required this.product,
  }) : super(key: key);

  final ProductDetailData product;

  @override
  _ProductSingleImagesState createState() => _ProductSingleImagesState();
}

class _ProductSingleImagesState extends State<ProductSingleImages> {
  int selectedImage = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        SizedBox(
          width: getProportionateScreenWidth(238),
          child: AspectRatio(
            aspectRatio: 1,
            child: Hero(
              tag: widget.product.productId.toString(),
              child: CachedImage(url: widget.product.images[selectedImage]),
            ),
          ),
        ),
        Padding(
          padding:
          EdgeInsets.symmetric(vertical: getProportionateScreenWidth(20)),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ...List.generate(widget.product.images.length,
                      (index) => buildSmallProductPreview(index)),
            ],
          ),
        ),
      ],
    );
  }

  GestureDetector buildSmallProductPreview(int index) {
    return GestureDetector(
      onTap: () {
        setState(() {
          selectedImage = index;
        });
      },
      child: AnimatedContainer(
        duration: defaultDuration,
        margin: const EdgeInsets.only(right: 15),
        padding: const EdgeInsets.all(8),
        height: getProportionateScreenWidth(48),
        width: getProportionateScreenWidth(48),
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(10),
          border: Border.all(
              color: kPrimaryColor.withOpacity(selectedImage == index ? 1 : 0)),
        ),
        child: CachedImage(
          url: widget.product.images[index],
        ),
      ),
    );
  }
}