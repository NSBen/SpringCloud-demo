package com.demo.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.annotation.CatAnnotation;
import com.demo.servicea.client.AccountRemoteApiClient;
import com.demo.servicea.client.StockRemoteApiClient;
import com.demo.servicea.config.DemoConfig;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeController {

	@Autowired
	private DemoConfig demoConfig;

	@Autowired
	private AccountRemoteApiClient accountApiClient;

	@Autowired
	private StockRemoteApiClient stockApiClient;

	@ApiOperation(value = "测试apollo的配置刷新  teststring配置项", notes = "")
	@GetMapping("/hi")
	public String home() {
		return "teststring配置项：" + demoConfig.getEnv();
	}

	@GetMapping("/health")
	public String health() {
		return "hello consul";
	}

	@GetMapping("/catLinkTest")
	@CatAnnotation
	public String catTest2() {
		String deductStock = stockApiClient.catTestStock("ss");
		String catTest4 = accountApiClient.catTest4();
		return deductStock+" "+catTest4;
	}
	
	@GetMapping("/catExceptionTest")
	@CatAnnotation
	public String catExceptionTest() {
		String deductStock = stockApiClient.catTestStock("ss");
		String catTest4 = accountApiClient.catExceptionTest();
		return deductStock+" "+catTest4;
	}

	@ApiOperation(value = "调用Account的支付方法", notes = "")
	@RequestMapping(value = "/api/order1", method = RequestMethod.GET)
	public String pay(@RequestParam("userId") String userId, @RequestParam("account") Integer account) {
		System.out.println(userId + account);
		// 扣钱
		String pay = accountApiClient.pay(userId, account);
		// 扣库存
		String deductStock = stockApiClient.deductStock("手机1", 1);

		return "扣钱：" + pay + "，扣库存：" + deductStock;
	}
}
