import 'package:hive/hive.dart';
import '../../../data/models/hives/repo/repo.dart';
import '../../../data/models/hives/sample_feature/sample_feature.dart';


class HiveAdapters {
  static const String PERSON = 'PersonAdapter';
  static const String REPO = 'RepoAdapter';

  static void register() {
    Hive.registerAdapter(PersonAdapter());
    Hive.registerAdapter(RepoAdapter());
  }
}