package com.demo.account.api.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.account.api.AccountRemoteApi;
import com.demo.common.annotation.CatAnnotation;

@RestController("/api")
public class AccountRemoteApiImpl implements AccountRemoteApi {

	@Override
	public String pay(@RequestParam("userId") String userId, @RequestParam("account") Integer account) {
		System.out.println("用户：" + userId + "，花了：" + account + "钱");
		return "扣钱成功";
	}

	@Override
	@CatAnnotation
	public String check(@RequestParam("userId") String userId) {
		System.out.println("用户：" + userId + "还有很多钱");
		return "查询成功";
	}

	@Override
	@CatAnnotation
	public String catTest3() {
		// TODO Auto-generated method stub
		return "catTest3";
	}

	@Override
	@CatAnnotation
	public String catTest4() {
		// TODO Auto-generated method stub
		return "catTest4";
	}

	@Override
	public String hi() {
		return "Demo-Ac";
	}

	@Override
	public String catExceptionTest() {
		throw new RuntimeException("抛异常");
	}

}
