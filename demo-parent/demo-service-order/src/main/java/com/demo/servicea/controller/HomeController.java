package com.demo.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.servicea.client.AccountRemoteApiClient;
import com.demo.servicea.config.DemoConfig;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeController {

	@Autowired
	private DemoConfig demoConfig;

	@Autowired
	private AccountRemoteApiClient accountApiClient;

	@ApiOperation(value = "测试apollo的配置刷新  teststring配置项", notes = "")
	@GetMapping("/hi")
	public String home() {
		return "teststring配置项：" + demoConfig.getEnv();
	}

	@GetMapping("/health")
	public String health() {
		return "hello consul";
	}

	@ApiOperation(value = "调用Account的支付方法", notes = "")
	@RequestMapping(value = "pay", method = RequestMethod.GET)
	public String pay(@RequestParam("userId") String userId, @RequestParam("account") Integer account) {
		System.out.println(userId + account);
		boolean pay = accountApiClient.pay(userId, account);
		return pay + "";
	}
}
