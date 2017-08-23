package org.springcloud.service.supply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(ConsulServiceApplication.class);
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsulServiceApplication.class).web(true).run(args);
		logger.info("ConsulService 服务提供方启动成功");
	}
}
