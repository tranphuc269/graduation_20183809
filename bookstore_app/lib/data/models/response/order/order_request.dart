class CreateOrderRequest {
  CreateOrderRequest(
      {required this.cartId,
      required this.paymentMethod,
      required this.addressRequest});

  Map<String, dynamic> toJson() {
    return {
      'cartId': 'ff808081855483340185548517d30000',
      'paymentMethod': 'VNPAY',
      'address': addressRequest.toJson()
    };
  }

  String cartId;
  PAYMENT_METHOD paymentMethod;
  OrderAddressRequest addressRequest;
}

enum PAYMENT_METHOD { COD, VNPAY, BANK_TRANSFER }

class OrderAddressRequest {
  OrderAddressRequest(
      {required this.phoneNumber,
      required this.detail,
      required this.district,
      required this.province,
      required this.city,
      required this.userName});

  Map<String, dynamic> toJson() {
    return {
      'city': city,
      'detail': detail,
      'district': district,
      'phoneNumber': phoneNumber,
      'province': province,
      'userName': userName,
    };
  }

  String city;
  String detail;
  String district;
  String phoneNumber;
  String province;
  String userName;
}

class OrderConfirmRequest {
  OrderConfirmRequest({required this.orderCheckingId});

  Map<String, dynamic> toJson() {
    return {
      'orderCheckingId': orderCheckingId,
    };
  }

  String orderCheckingId;
}
