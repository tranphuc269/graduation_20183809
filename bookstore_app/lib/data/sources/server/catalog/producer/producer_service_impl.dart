import '../../../../../core/network/api_request.dart';
import '../../../../models/response/producer/producer_data.dart';
import '../../../../models/response/producer/producer_response.dart';
import 'producer_service.dart';

class ProducerServiceImpl extends ProducerService{
  @override
  Future<List<ProducerData>> getAllProducer() async{
    // const url = '/catalog-service/producer';
    // // TODO: implement getAllBanner
    // final _res = await sendRequest(
    //   url: url,
    //   requestMethod: RequestMethod.GET,
    //   useToken: true,
    // );
    // final ProducerResponse producer = ProducerResponse.fromJson(_res.data);
    return [];
    // return producer.data;
  }
}