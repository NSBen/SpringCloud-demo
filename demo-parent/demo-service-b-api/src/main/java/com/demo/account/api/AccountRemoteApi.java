package com.demo.account.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface AccountRemoteApi {

	/**
	 * 支付扣钱
	 * 
	 * @param userId
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "pay", method = RequestMethod.GET)
	public boolean pay(@RequestParam("userId") String userId, @RequestParam("account") Integer account);

}
