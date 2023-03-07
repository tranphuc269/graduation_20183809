import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:logger/logger.dart';

import 'base_controller.dart';

/// ElementViewBase
abstract class ElementViewBase<T extends BaseController> extends GetView<T> {
  /// logger
  final logger = Logger();

  /// viewModel
  T get viewModel => GetInstance().find<T>(tag: tag);

}
