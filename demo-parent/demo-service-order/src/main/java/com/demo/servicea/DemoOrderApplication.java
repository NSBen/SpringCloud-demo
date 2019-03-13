package com.demo.servicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
@EnableFeignClients
public class DemoOrderApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoOrderApplication.class, args);
	}

}
