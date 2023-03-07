import 'dart:convert';
import 'dart:developer';

import 'package:dio/dio.dart';

import 'api_token_manager.dart';

class ApiInterceptors extends ApiTokenManager
    implements QueuedInterceptorsWrapper {
  ApiInterceptors(this._dio);
  final Dio _dio;

  @override
  Future<dynamic> onRequest(options, handler) async {
    try {
      log('------ BEGIN REQUEST ------');
      log(options.toCurlCmd());
      log('------ END REQUEST ------');
    } catch (e) {
      log('Create CURL failure!! - $e');
    }
    return handler.next(options);
  }

  @override
  Future<dynamic> onResponse(Response response, handler) async {
    final data = response.data;
    _prettyPrintJson(data, response.requestOptions);
    return super.onResponse(response, handler);
  }

  @override
  Future<dynamic> onError(DioError err, handler) async {
    // print('err : ${err.response}');

    if(err.response is List){
      handler.next(err);
    }else{
      await handleToken(
        dio: _dio,
        err: err,
        handler: handler,
      );
    }


  }
  void _prettyPrintJson(Object response, RequestOptions options) {
    try {
      log('------ BEGIN REQUEST ------');
      log(options.toCurlCmd());
      log('------ END REQUEST ------');
    } catch (e) {
      log('Create CURL failure!! - $e');
    }
    log(response.toString());
  }
}

extension Curl on RequestOptions {
  String toCurlCmd() {
    String cmd = 'curl';

    final String header = this
        .headers
        .map((key, value) {
      if (key == 'content-type' &&
          value.toString().contains('multipart/form-data')) {
        value = 'multipart/form-data;';
      }
      return MapEntry(key, "-H '$key: $value'");
    })
        .values
        .join(' ');
    String url = '$baseUrl$path';
    if (this.queryParameters.length > 0) {
      final String query = this
          .queryParameters
          .map((key, value) {
        return MapEntry(key, '$key=$value');
      })
          .values
          .join('&');

      url += (url.contains('?')) ? query : '?$query';
    }
    if (this.method == 'GET') {
      cmd += " $header '$url'";
    } else {
      final Map<String, dynamic> files = {};
      String postData = "-d ''";
      if (data != null) {
        if (data is FormData) {
          final FormData fdata = data as FormData;
          fdata.files.forEach((element) {
            final MultipartFile file = element.value;
            files[element.key] = '@${file.filename}';
          });
          fdata.fields.forEach((element) {
            files[element.key] = element.value;
          });
          if (files.length > 0) {
            postData = files
                .map((key, value) => MapEntry(key, "-F '$key=$value'"))
                .values
                .join(' ');
          }
        } else if (data is Map<String, dynamic>) {
          files.addAll(data);

          if (files.length > 0) {
            postData = "-d '${json.encode(files).toString()}'";
          }
        }
      }

      final String method = this.method.toString();
      cmd += " -X $method $postData $header '$url'";
    }

    return cmd;
  }
}