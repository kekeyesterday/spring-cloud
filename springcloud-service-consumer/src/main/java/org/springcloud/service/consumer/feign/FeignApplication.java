package org.springcloud.service.consumer.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.HystrixCommandProperties;

import feign.Request;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApplication {
	private static Logger logger = LoggerFactory.getLogger(FeignApplication.class);
	
	
	public static void main(String[] args) {
		HystrixCommandProperties.Setter setter = HystrixCommandProperties.Setter();
		//setter.withExecutionIsolationThreadTimeoutInMilliseconds(10000);
		setter.withCircuitBreakerErrorThresholdPercentage(10);
		setter.withCircuitBreakerRequestVolumeThreshold(5);//采样周期内5个
		setter.withMetricsRollingStatisticalWindowBuckets(5);
		SpringApplication.run(FeignApplication.class, 
				args);
		logger.info("[feign]服务消费者启动成功");
	}
	
    @Bean
    Request.Options feignOptions() {
        return new Request.Options(/**connectTimeoutMillis**/10 * 1000, /** readTimeoutMillis **/10 * 1000);
    }
}
