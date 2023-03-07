package com.bookstore.orderservice.application.client.model;


import com.bookstore.orderservice.common.application.response.dto.BaseResponse;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class VNPayResponseClient {
    private VNPAYResponseData data;
    private BaseResponse.Metadata meta;
}
