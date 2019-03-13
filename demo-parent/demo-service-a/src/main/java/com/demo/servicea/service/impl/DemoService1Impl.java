package com.demo.servicea.service.impl;

import org.springframework.stereotype.Service;

import com.demo.servicea.service.IDemoService1;

@Service
public class DemoService1Impl implements IDemoService1 {

	@Override
	public void printlStr(String str) {
		System.out.println(str);
	}
	
}
