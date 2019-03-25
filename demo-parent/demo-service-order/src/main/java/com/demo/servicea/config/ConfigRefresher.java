package com.demo.servicea.config;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.demo.common.constant.Constants;

@Service
public class ConfigRefresher implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	RefreshMapperCache refreshMapper;
	
	@ApolloConfig
	private Config config;

	@PostConstruct
	private void initialize() {
		refresher(config.getPropertyNames());
	}
	

	@ApolloConfigChangeListener
	private void onChange(ConfigChangeEvent changeEvent) {
		for (String key : changeEvent.changedKeys()) {
			ConfigChange change = changeEvent.getChange(key);
			if(key.startsWith(Constants.APOLLO_MAPPER_PREFIX)) {
				//动态刷新mybatis的mapper文件
				refreshMapper.refreshMapper(change.getNewValue(),key);
			}
		}
		refresher(changeEvent.changedKeys());
	}

	private void refresher(Set<String> changedKeys) {
		for (String changedKey : changedKeys) {
			System.out.println("this key is changed:" + changedKey);
		}
		this.applicationContext.publishEvent(new EnvironmentChangeEvent(changedKeys));

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
