package com.demo.servicea.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.demo.common.interceptor.CatFeignConfiguration;
import com.demo.stock.api.StockRemoteApi;

@FeignClient(name="demo-stock", configuration = CatFeignConfiguration.class)
public interface StockRemoteApiClient extends StockRemoteApi {

}
