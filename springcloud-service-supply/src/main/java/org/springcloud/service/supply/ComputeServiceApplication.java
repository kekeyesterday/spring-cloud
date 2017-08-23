package org.springcloud.service.supply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import  org.springframework.cloud.client.serviceregistry.Registration;

import com.netflix.hystrix.HystrixCommandProperties;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class ComputeServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(ComputeServiceApplication.class);
	
	public static void main(String[] args) {
		HystrixCommandProperties.Setter setter = HystrixCommandProperties.Setter();
		//setter.withExecutionIsolationThreadTimeoutInMilliseconds(10000);
		
		
		setter.withCircuitBreakerErrorThresholdPercentage(10);
		setter.withCircuitBreakerRequestVolumeThreshold(5);//采样周期内5个
		setter.withMetricsRollingStatisticalWindowBuckets(5);
		
		
		new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
		logger.info("服务提供方启动成功");
	}
}
