package com.demo.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.demo"})
public class DemoStockApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoStockApplication.class, args);
	}

}
