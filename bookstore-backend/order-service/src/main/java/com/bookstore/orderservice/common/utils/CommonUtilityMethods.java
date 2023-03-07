package com.bookstore.orderservice.common.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CommonUtilityMethods {

    public static String getUserIdFromToken(Authentication authentication) {
        Map<String, String> map = (Map<String, String>)((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        return map.get("user_id");
    }

    public static String getUserNameFromToken(Authentication authentication) {
        Map<String, String> map = (Map<String, String>)((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        return map.get("user_name");
    }

    public static String getTokenFromRequestHeader(HttpHeaders headers){
        List<String> splitToken = Arrays.asList(Objects.requireNonNull(headers.get("authorization")).toString().split(" "));
        return splitToken.get(1).replaceAll("]", "");
    }
}