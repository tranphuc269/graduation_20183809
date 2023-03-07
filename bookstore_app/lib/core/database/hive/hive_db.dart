import 'package:hive/hive.dart';
import 'package:path_provider/path_provider.dart';

import 'hive_adapters.dart';
import 'hive_box.dart';


class HiveDb {
  static Future init() async {
    HiveAdapters.register();

    final appDocumentDir = await getApplicationDocumentsDirectory();
    Hive.init(appDocumentDir.path);
    await Hive.openBox(HiveBox.user);
    await Hive.openBox(HiveBox.repo);
  }
}