package com.demo.account.api.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.account.api.AccountRemoteApi;

@RestController
public class AccountRemoteApiImpl implements AccountRemoteApi {

	@Override
	public boolean pay(@RequestParam("userId") String userId, @RequestParam("account") Integer account) {
		System.out.println("用户：" + userId + "，花了：" + account + "钱");
		return true;
	}

}
