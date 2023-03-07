class CategoryData {
  CategoryData(
      {required this.image,
      required this.categoryName,
      required this.categoryId,
      required this.description});

  factory CategoryData.fromJson(Map<String, dynamic> json) {
    return CategoryData(
      description: json['description'],
      image: json['image'],
      categoryName: json['categoryName'],
      categoryId: json['categoryId'],
    );
  }

  String categoryId;
  String categoryName;
  String description;
  String image;
}
