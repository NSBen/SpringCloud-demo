package com.demo.account.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.common.fliter.CatContextServletFilter;

@Configuration
public class WebConfig {
	/**
	 * cat的埋点过滤器
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean catFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		CatContextServletFilter filter = new CatContextServletFilter();
		Set<String> set = new HashSet<>(Arrays.asList("/health"));
		filter.setAllowedPaths(set);
		registration.setFilter(filter);
		registration.addUrlPatterns("/*");
		registration.setName("cat-filter");
		registration.setOrder(2);
		return registration;
	}
}
