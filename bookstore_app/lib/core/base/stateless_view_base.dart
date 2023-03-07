import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:logger/logger.dart';

import 'base_controller.dart';
import 'view_interface.dart';

/// StateLessViewBase
abstract class StateLessViewBase<T extends BaseController> extends GetView<T>
    with ViewInterface {
  /// logger
  final logger = Logger();

  /// viewModel
  T get viewModel => GetInstance().find<T>(tag: tag);

  @override
  Widget build(BuildContext context) {
    return WillPopScope(child: buildPage(context), onWillPop: willPopCallBack);
  }

  /// willPopCallBack
  Future<bool> willPopCallBack() async {
    return true;
  }
}
