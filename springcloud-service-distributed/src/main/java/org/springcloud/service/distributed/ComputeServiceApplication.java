package org.springcloud.service.distributed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputeServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(ComputeServiceApplication.class);
	
	@Value("server.port")
	static String serverPort;
	public static void main(String[] args) {
		new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
		logger.info("===server.port==="+ serverPort);
		logger.info("服务提供方启动成功");
	}
}
