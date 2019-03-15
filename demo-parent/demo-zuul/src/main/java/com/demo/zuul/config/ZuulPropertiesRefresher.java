package com.demo.zuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.demo.zuul.DemoZullApplication;

@Component
public class ZuulPropertiesRefresher {

	private static final Logger logger = LoggerFactory.getLogger(ZuulPropertiesRefresher.class);

	@Autowired
	private RefreshScope refreshScope;

	@ApolloConfigChangeListener
	public void onChange(ConfigChangeEvent changeEvent) {
		boolean zuulPropertiesChanged = false;
		for (String changedKey : changeEvent.changedKeys()) {
			if (changedKey.startsWith("zuul.")) {
				zuulPropertiesChanged = true;
				break;
			}
		}

		if (zuulPropertiesChanged) {
			logger.info("Refreshing zuul properties!");
			refreshScope.refresh(DemoZullApplication.ZUUL_PROPERTIES_BEAN);
		}
	}

}
