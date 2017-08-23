package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.beans.factory.config.EmbeddedValueResolver;

//@EnableEurekaServer
@EnableDiscoveryClient
@SpringBootApplication
public class ZKApplication {
	private static Logger logger = LoggerFactory.getLogger(ZKApplication.class);
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZKApplication.class).web(true).run(args);
		logger.info("zookeeper2  服务注册中心启动成功!");
	}
}
