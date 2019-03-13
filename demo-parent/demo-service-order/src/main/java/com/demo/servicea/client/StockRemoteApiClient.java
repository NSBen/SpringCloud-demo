package com.demo.servicea.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.demo.stock.api.StockRemoteApi;

@FeignClient("demo-stock")
public interface StockRemoteApiClient extends StockRemoteApi {

}
