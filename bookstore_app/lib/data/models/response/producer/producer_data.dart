class ProducerData {
  ProducerData(
      {required this.img,
      required this.description,
      required this.producerId,
      required this.producerName});

  factory ProducerData.fromJson(Map<String, dynamic> json) {
    return ProducerData(
      img: json['img'],
      description: json['description'],
      producerId: json['producerId'],
      producerName: json['producerName'],
    );
  }

  String producerId;
  String producerName;
  String description;
  String img;
}
