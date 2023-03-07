import '../../base_response.dart';

class AuthorResponse extends BaseResponse {
  AuthorResponse({required super.meta});
}

class AuthorData {
  AuthorData(
      {required this.name, required this.images, required this.authorId});

  factory AuthorData.fromJson(Map<String, dynamic> json) {
    return AuthorData(
      name: json['name'],
      images: (json['images'] as List).map((e) => e.toString()).toList(),
      authorId: json['authorId'],
    );
  }

  String authorId;
  String name;
  List<String> images;
}
