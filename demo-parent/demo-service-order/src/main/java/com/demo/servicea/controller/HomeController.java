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
import com.demo.servicea.mapper.SysDeptMapper;
import com.demo.servicea.mapper.SysTenementMapper;
import com.demo.servicea.service.impl.DemoService1Impl;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeController {

	@Autowired
	private DemoConfig demoConfig;

	@Autowired
	private AccountRemoteApiClient accountApiClient;

	@Autowired
	private StockRemoteApiClient stockApiClient;

	@Autowired
	private DemoService1Impl s1;

	@Autowired
	private SysDeptMapper mapper;

	@Autowired
	private SysTenementMapper mapper2;

	@ApiOperation(value = "测试mybatis的mapper修改", notes = "")
	@GetMapping("/testMybatis")
	public String testMybatis() {
		String string = mapper.select28().toString();
		return string;
	}

	@ApiOperation(value = "测试mybatis的mapper修改2", notes = "")
	@GetMapping("/testMybatis2")
	public String testMybatis2() {
		return mapper2.select1().toString();
	}

	@ApiOperation(value = "测试apollo的配置刷新  teststring配置项", notes = "")
	@GetMapping("/hi")
	public String home() {
		return "teststring配置项：" + demoConfig.getEnv();
	}

	@ApiOperation(value = "测试apollo的配置刷新  teststring配置项", notes = "")
	@GetMapping("/localCat")
	public String localCat() {
		s1.printlStr("aaaaa");
		return "ok";
	}

	@ApiOperation(value = "consul的心跳测试接口", notes = "")
	@GetMapping("/health")
	public String health() {
		return "hello consul";
	}

	@ApiOperation(value = "Cat监控调用链", notes = "")
	@GetMapping("/catLinkTest")
	@CatAnnotation
	public String catTest2() {
		String deductStock = stockApiClient.catTestStock("ss");
		String catTest4 = accountApiClient.catTest4();
		return deductStock + " " + catTest4;
	}

	@ApiOperation(value = "Cat监控调用链报错的情况", notes = "")
	@GetMapping("/catExceptionTest")
	@CatAnnotation
	public String catExceptionTest() {
		String deductStock = stockApiClient.catTestStock("ss");
		String catTest4 = accountApiClient.catExceptionTest();
		return deductStock + " " + catTest4;
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
