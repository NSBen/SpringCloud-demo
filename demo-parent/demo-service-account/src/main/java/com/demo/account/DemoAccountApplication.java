package com.demo.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.demo.common"})
public class DemoAccountApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoAccountApplication.class, args);
	}

}
