import 'package:intl/intl.dart';

extension DoubleExtension on double {
  String formatMoney(){
    final formatCurrency = new NumberFormat.compactLong(locale: 'vi');
    return formatCurrency.format(this);
  }
}