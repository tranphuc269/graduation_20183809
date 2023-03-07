import 'package:get/get.dart';

import 'languages/english.dart';
import 'languages/vietnam.dart';


class AppTranslation extends Translations {
  @override
  Map<String, Map<String, String>> get keys => {
    'en': en,
    'vi': vi,
  };
}