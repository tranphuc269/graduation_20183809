import 'package:calendar_date_picker2/calendar_date_picker2.dart';
import 'package:flutter/material.dart';

class DatePickerWidget extends StatelessWidget {

  const DatePickerWidget({
    Key? key,
    this.calendarType,
    this.onSelectionChanged,
    this.initialValue,
    this.height,
    this.width,
    this.weekLabelStyle,
    this.weekLabel,
    this.firstDate,
    this.lastDate,
    this.startDate,
    this.selectedHighlightColor,
    this.viewMode,
  }) : super(key: key);
  factory DatePickerWidget.range({
    required Function(PickerDateRange? selected) onSelectionChanged,
    double? height,
    double? width,
    DateTime? firstDate,
    DateTime? lastDate,
    Color? selectedHighlightColor,
    PickerDateRange? initialValue,
  }) =>
      DatePickerWidget(
        height: height,
        width: width,
        selectedHighlightColor: selectedHighlightColor,
        firstDate: firstDate,
        lastDate: lastDate,
        initialValue: initialValue,
        calendarType: CalendarDatePicker2Type.range,
        onSelectionChanged: (selected) {
          if (selected.length == 2) {
            final PickerDateRange selectedDate =
            PickerDateRange(selected[0], selected[1]);
            onSelectionChanged(selectedDate);
          }
        },
      );

  factory DatePickerWidget.multi({
    required Function(List<DateTime?> selected) onSelectionChanged,
    double? height,
    double? width,
    DateTime? firstDate,
    DateTime? lastDate,
    PickerDateRange? initialValue,
  }) =>
      DatePickerWidget(
        height: height,
        width: width,
        firstDate: firstDate,
        lastDate: lastDate,
        initialValue: initialValue,
        calendarType: CalendarDatePicker2Type.multi,
        onSelectionChanged: (selected) {
          onSelectionChanged(selected as List<DateTime?>);
        },
      );

  factory DatePickerWidget.single({
    required Function(PickerDateSingle? selected) onSelectionChanged,
    double? height,
    double? width,
    DateTime? firstDate,
    DateTime? lastDate,
    PickerDateRange? initialValue,
  }) =>
      DatePickerWidget(
        height: height,
        width: width,
        firstDate: firstDate,
        lastDate: lastDate,
        initialValue: initialValue,
        calendarType: CalendarDatePicker2Type.single,
        onSelectionChanged: (selected) {
          final PickerDateSingle selectedDate = PickerDateSingle(selected[0]);
          onSelectionChanged(selectedDate);
        },
      );

  final double? height;
  final double? width;
  final TextStyle? weekLabelStyle;
  final List<String>? weekLabel;
  final Function(List)? onSelectionChanged;
  final CalendarDatePicker2Type? calendarType;
  final PickerDateRange? initialValue;
  final DateTime? firstDate;
  final DateTime? lastDate;
  final DateTime? startDate;
  final Color? selectedHighlightColor;
  final DatePickerMode? viewMode;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: height ?? 300,
      width: width,
      child: CalendarDatePicker2(
        config: CalendarDatePicker2Config(
          calendarType: calendarType,
          weekdayLabelTextStyle: weekLabelStyle,
          weekdayLabels: weekLabel,
          firstDate: firstDate,
          lastDate: lastDate,
          currentDate: startDate,
          selectedDayHighlightColor: selectedHighlightColor,
          calendarViewMode: viewMode,
        ),
        initialValue: [initialValue?.startDate, initialValue?.endDate],
        onValueChanged: onSelectionChanged,
      ),
    );
  }
}

class PickerDateRange {
  const PickerDateRange(this.startDate, this.endDate);
  final DateTime? startDate;
  final DateTime? endDate;
}

class PickerDateMulti {
  const PickerDateMulti(this.listDate);
  final List<DateTime?> listDate;
}

class PickerDateSingle {
  const PickerDateSingle(this.date);
  final DateTime? date;
}