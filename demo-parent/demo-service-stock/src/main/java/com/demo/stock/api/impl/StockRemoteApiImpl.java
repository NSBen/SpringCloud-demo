package com.demo.stock.api.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.stock.api.StockRemoteApi;

@RestController
public class StockRemoteApiImpl implements StockRemoteApi {

	@Override
	public boolean deductStock(@RequestParam("goodId") String goodId, @RequestParam("num") Integer num) {
		System.out.println("商品:"+goodId+",扣了"+num+"个库存");
		return false;
	}

}
