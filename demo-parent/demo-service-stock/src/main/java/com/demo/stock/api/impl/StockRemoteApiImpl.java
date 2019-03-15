package com.demo.stock.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.annotation.CatAnnotation;
import com.demo.stock.api.StockRemoteApi;
import com.demo.stock.client.AccountRemoteApiClient;

@RestController
public class StockRemoteApiImpl implements StockRemoteApi {

	@Autowired
	private AccountRemoteApiClient accountClient;

	@Override
	public String deductStock(@RequestParam("goodId") String goodId, @RequestParam("num") Integer num) {
		String check = accountClient.check("aa");
		System.out.println("商品:" + goodId + ",扣了" + num + "个库存");
		return check + ",扣库存成功";
	}

	@Override
	@CatAnnotation
	public String catTestStock(String goodId) {
		accountClient.catTest3();
		accountClient.check("aaa");
		return "catTestStock";
	}

}
