package com.demo.servicea.service.impl;

import org.springframework.stereotype.Service;

@Service
public class TestService2 {
	public void test2() {
		System.out.println("TestService2.test2");
		throw new RuntimeException("TestService2.test2 trow Exception");
	}
}
