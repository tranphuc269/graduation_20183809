enum DeviceType {
  IPHONE,
  IPAD,
}

class ScreenHelper {
  ScreenHelper({required this.size});

  factory ScreenHelper.portrait({required double height}) {
    return ScreenHelper(size: height);
  }

  factory ScreenHelper.landscape({required double width}) {
    return ScreenHelper(size: width);
  }
  final double size;

  DeviceType iOS() {
    if(size>=956) {
      return DeviceType.IPAD;
    } else {
      return DeviceType.IPHONE;
    }
  }
}