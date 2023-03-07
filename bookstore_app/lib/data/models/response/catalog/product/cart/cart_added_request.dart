class CartAddedRequest {
  CartAddedRequest({required this.productId});

  Map<String, dynamic> toJson() {
    return {'productId': productId};
  }

  String productId;
}
