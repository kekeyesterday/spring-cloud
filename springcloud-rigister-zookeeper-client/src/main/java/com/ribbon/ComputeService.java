package com.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RibbonClient(value="zk-service-supply")
public class ComputeService {
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
    @Autowired
    RestTemplate restTemplate;
    public String getUserInfo() {
    	String url = "http://"+"zk-service-supply".toUpperCase()+"/getUserInfo?id={id}";
    	System.out.println("====================url=====::" + url);
        return restTemplate.getForEntity(url, String.class,100).getBody();
    }
    
 
    public String getUserInfoFallback() {
        return "error";
    }
}
