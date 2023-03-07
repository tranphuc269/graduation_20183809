import 'package:intl/intl.dart';

import '../database/get_storage/get_storage_key.dart';
import '../database/get_storage/get_storage_manager.dart';

/// If you want to convert 1 date, just fill [date].
/// If you want to convert range date, you can fill [startDate], [endDate]
/// * Example : DateHelper(startDate: x, endDate: y).format2()
class DateTimeHelper {

  DateTimeHelper({
    this.date,
    this.startDate,
    this.endDate
  });

  DateTime? date;
  DateTime? startDate;
  DateTime? endDate;

  String? format() {
    return formatDate(pattern: 'dd MM yyyy - HH:mm:ss');
  }

  String? format2() {
    return formatDate(pattern: 'dd MM yyyy');
  }

  String? format3() {
    return formatDate(pattern: 'dd-MM-yyyy');
  }

  String? format4() {
    return formatDate(pattern: 'EEEE, dd MM y');
  }

  String? format5() {
    return formatDate(pattern: 'EEEE, dd MMMM yyyy HH:mm');
  }

  String? formatDays() {
    return formatDate(pattern: 'dd');
  }

  String? formatHours() {
    return formatDate(pattern: 'HH:mm');
  }

  String? formatDate({String? pattern}) {
    final bool isRange = startDate != null && endDate != null;
    final bool isNotRange = startDate == null && endDate == null;
    final String locale = GetStorageManager.find.get(GetStorageKey.CURRENT_LOCALE);

    if(isRange && date == null) {
      final start = DateFormat(pattern, locale).format(startDate!);
      final end = DateFormat(pattern, locale).format(endDate!);
      return '$start - $end';
    } else if (date != null && isNotRange) {
      return DateFormat(pattern, locale).format(date!);
    } else {
      return 'Error date converted!';
    }
  }
}

extension DateHelpers on DateTime {
  bool isToday() {
    final now = DateTime.now();
    return now.day == day &&
        now.month == month &&
        now.year == year;
  }

  bool isYesterday() {
    final yesterday = DateTime.now().subtract(const Duration(days: 1));
    return yesterday.day == day &&
        yesterday.month == month &&
        yesterday.year == year;
  }

  bool isTomorrow() {
    final yesterday = DateTime.now().add(const Duration(days: 1));
    return yesterday.day == day &&
        yesterday.month == month &&
        yesterday.year == year;
  }

  bool inThisWeek() {
    final weekAgo = DateTime.now().subtract(const Duration(days: 7));
    return isAfter(weekAgo);
  }

  bool inThisYear() {
    final yearAgo = DateTime.now().subtract(const Duration(days: 365));
    return isAfter(yearAgo);
  }
}