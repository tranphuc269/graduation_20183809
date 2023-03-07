import 'dart:convert';
import 'dart:developer';
import 'dart:io';

import 'package:dio/dio.dart';

import '../database/secure_storage/secure_storage_manager.dart';
import 'api_config.dart';
import 'api_exception.dart';
import 'api_url.dart';

// ignore: constant_identifier_names
enum RequestMethod { GET, POST, PATCH, PUT, DELETE }

Map<String, String> headers = {
  HttpHeaders.authorizationHeader: 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsid2ViIl0sInVzZXJfaWQiOiJ4Y3ZjdmJ2di1iYTVkLTRiOTItODViZS1kZmdkZmdkZmdkZmciLCJ1c2VyX25hbWUiOiJhZG1pbi5hZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE2Njg5MzM0NTIsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6Ii1RbVlWX2hYUThKMVh1b2pkaDF5NFRheHpuYyIsImNsaWVudF9pZCI6IjkzZWQ0NTNlLWI3YWMtNDE5Mi1hNmQ0LWM0NWZhZTBkOTlhYyJ9.kIHixGZtoiM8zi7k_ahHUONJNYMbcs3PuSfe17hGOdyhcwoHfYjYwWeXtr017Vn-D-ldN2PURgnXM-a1h5CRrvAez3-WBkyq46wPE987tDy7YVkXazd5JUI9Z8rt7yGvT9RDPbgRa8GbtJPycbrE8Bo2OgWh5YP5-9UExB1OoQauv1vSa6j9T8CPfsyXX_G0dy37o7l-beIP_5IqTUArweb0A5INNPjJr3YQJ12XkDOvwpQnVxhHwGGoyk23_oPdBy7g53hi1G5UglmX2_KLEZFbnWSp6JucwT7KWlvJYPmHt1Fq8IYjLV2pWrfLZZLcxnRcFCr8_enmV8UdX2yZlQ',
};

/// Base Request for calling API.
/// * Can be modify as needed.
Future<Response> sendRequest({
  required RequestMethod requestMethod,
  required String url,
  Object? body,
  bool useToken = true,
  String? contentType = Headers.jsonContentType,
}) async {
  await _tokenManager(useToken);
  try {
    switch (requestMethod) {
      case RequestMethod.POST:
        return await _safeFetch(
          () => dioClient.post(
            url,
            data: _setBody(contentType: contentType, body: body),
            options: Options(headers: headers, contentType: contentType),
          ),
        );
      case RequestMethod.GET:
        return await _safeFetch(
          () => dioClient.get(
            url,
            options: Options(headers: headers, contentType: contentType),
          ),
        );
      case RequestMethod.PATCH:
        return await _safeFetch(
          () => dioClient.patch(
            url,
            data: _setBody(contentType: contentType, body: body),
            options: Options(headers: headers, contentType: contentType),
          ),
        );
      case RequestMethod.PUT:
        return await _safeFetch(
          () => dioClient.put(
            url,
            data: _setBody(contentType: contentType, body: body),
            options: Options(headers: headers, contentType: contentType),
          ),
        );
      case RequestMethod.DELETE:
        return await _safeFetch(
          () => dioClient.delete(
            url,
            data: _setBody(contentType: contentType, body: body),
            options: Options(headers: headers),
          ),
        );
    }
  } catch (error) {
    rethrow;
  }
}

Object? _setBody({
  required String? contentType,
  required Object? body,
}) {
  if (contentType == Headers.jsonContentType) {
    // body = jsonEncode(body);
    return body;
  } else if (contentType == Headers.formUrlEncodedContentType) {
    return body;
  } else if (contentType == ApiUrl.multipartFormData) {
    return FormData.fromMap(body as Map<String, dynamic>);
  }
  return null;
}
Future<void> _tokenManager(bool useToken) async {
  DioClient.setInterceptor();
  final String? token = await SecureStorageManager.find.getToken();
  if (useToken) {
    headers[HttpHeaders.authorizationHeader] = 'Bearer $token';
  } else {
    headers.clear();
  }
  headers[HttpHeaders.authorizationHeader] = 'Bearer $token';
}

/// Wrap fetch request with try-catch
/// & error handling
Future<Response> _safeFetch(Future<Response> Function() tryFetch) async {
  final response = await tryFetch();
  // return ApiResponse.fromJson(response.data);
  return response;
}
