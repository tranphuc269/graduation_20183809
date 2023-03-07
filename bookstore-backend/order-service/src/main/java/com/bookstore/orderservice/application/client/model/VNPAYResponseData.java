package com.bookstore.orderservice.application.client.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Builder
@Getter
@Setter
public class VNPAYResponseData {
    String status;
    String message;
    String url;
}
