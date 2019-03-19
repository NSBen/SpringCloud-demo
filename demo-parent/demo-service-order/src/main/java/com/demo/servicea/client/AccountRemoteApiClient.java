package com.demo.servicea.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.demo.account.api.AccountRemoteApi;
import com.demo.common.interceptor.CatFeignConfiguration;

@FeignClient(name="demo-account", configuration = CatFeignConfiguration.class)
public interface AccountRemoteApiClient extends AccountRemoteApi {

}
