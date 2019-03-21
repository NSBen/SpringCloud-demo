package com.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.demo.zuul.filter.CatZuulFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableApolloConfig
@RestController
public class DemoZullApplication {

	public static final String ZUUL_PROPERTIES_BEAN = "ZUUL_PROPERTIES_BEAN";

	@Primary
	@Bean(ZUUL_PROPERTIES_BEAN)
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}
	
	@Bean
	public CatZuulFilter catZuulFilter() {
		return new CatZuulFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoZullApplication.class, args);
	}

	
}
