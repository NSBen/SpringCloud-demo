package com.demo.servicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableApolloConfig
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.demo"})
@EnableSwagger2
public class DemoOrderApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoOrderApplication.class, args);
	}

}
