package com.demo.stock.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface StockRemoteApi {
	/**
	 * 扣库存
	 * @param goodId
	 * @param num
	 * @return
	 */
	@RequestMapping(value = "deductStock", method = RequestMethod.GET)
	public boolean deductStock(@RequestParam("goodId") String goodId, @RequestParam("num") Integer num);
}
