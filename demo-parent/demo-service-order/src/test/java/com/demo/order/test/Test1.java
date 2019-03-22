package com.demo.order.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.demo.servicea.DemoOrderApplication;
import com.demo.servicea.entity.SysDept;
import com.demo.servicea.entity.SysTenement;
import com.demo.servicea.mapper.SysDeptMapper;
import com.demo.servicea.mapper.SysTenementMapper;
import com.demo.servicea.mapper.SysTenementTypeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoOrderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {

	@Autowired
	SysDeptMapper mapper;
	
	@Autowired
	SysTenementMapper stm;
	
	@Autowired
	SysTenementTypeMapper sttm;
	
	@Test
	public void test() {

        List<Resource> resources = new ArrayList<Resource>();
        Config config = ConfigService.getAppConfig();
        String key = "SysDeptMapper";
        String defaultValue = "apollo_client"; 
        String value = config.getProperty(key,defaultValue);
        InputStream is = new ByteArrayInputStream(value.getBytes());
        InputStreamResource a = new InputStreamResource(is,key);
        resources.add(a);
        
        SysTenement select1 = stm.select1();
        
    
        SysDept selectById = mapper.select28();
        System.out.println(select1);
	}
}
