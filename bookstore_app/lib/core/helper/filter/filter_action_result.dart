enum FilterAction {
  submit,
  cancel,
}

class FilterResult<T> {

  FilterResult({required this.action, required this.value});
  FilterAction action;
  List<T> value;
}