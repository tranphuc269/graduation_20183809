import '../../../../models/response/producer/producer_data.dart';

abstract class ProducerService {
  Future<List<ProducerData>> getAllProducer();
}
