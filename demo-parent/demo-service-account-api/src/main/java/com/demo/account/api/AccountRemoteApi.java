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
	@RequestMapping(value = "/account/pay", method = RequestMethod.GET)
	public String pay(@RequestParam("userId") String userId, @RequestParam("account") Integer account);

	/**
	 * 查询账户余额
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/account/check", method = RequestMethod.GET)
	public String check(@RequestParam("userId") String userId);

	@RequestMapping(value = "/account/catTestAccount3", method = RequestMethod.GET)
	public String catTest3();

	@RequestMapping(value = "/account/catTestAccount4", method = RequestMethod.GET)
	public String catTest4();
	
	@RequestMapping(value = "/account/hi", method = RequestMethod.GET)
	public String hi();

}
