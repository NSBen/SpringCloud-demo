package com.demo.stock.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.demo.account.api.AccountRemoteApi;

@FeignClient("demo-account")
public interface AccountRemoteApiClient extends AccountRemoteApi {

}
