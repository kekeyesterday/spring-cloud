package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.event.GenericApplicationListener;
//import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
	private static Logger logger = LoggerFactory.getLogger(EurekaApplication.class);
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
		logger.info("服务注册中心启动成功!");
	}
}
