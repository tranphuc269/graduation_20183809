
import 'package:hive/hive.dart';

import '../../../../core/database/hive/hive_box.dart';
import '../../../models/hives/sample_feature/sample_feature.dart';
import 'sample_feature_dao.dart';

class SampleFeatureDaoImpl implements SampleFeatureDao {
  final box = Hive.box(HiveBox.user);

  @override
  bool boxIsEmpty() => box.isNotEmpty;

  @override
  bool containData(SampleFeature user) {
    final SampleFeature _data = box.get(user.id);
    return box.containsKey(user.id) && _data.repository != null;
  }

  @override
  SampleFeature get(int id) => box.get(id);

  @override
  void insert(SampleFeature user) => box.put(user.id, user);

  @override
  void insertAll(List<SampleFeature> users) {
    users.asMap().forEach((i, value) {
      box.put(users[i].id, users[i]);
    });
  }

  @override
  List<SampleFeature> getAll() {
    final List<SampleFeature> _users = [];
    for (var i = 0; i < box.length; i++) {
      _users.add(box.getAt(i));
    }
    return _users;
  }

  @override
  void deleteAll(List<SampleFeature> users) {
    box.deleteAll(users);
  }

  @override
  void clear() => box.clear();

  @override
  void delete(SampleFeature user) {
    box.delete(user);
  }
}