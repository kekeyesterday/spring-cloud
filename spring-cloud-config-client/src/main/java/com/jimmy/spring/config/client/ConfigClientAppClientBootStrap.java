package com.jimmy.spring.config.client;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.beans.factory.config.EmbeddedValueResolver;


@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientAppClientBootStrap {
	private static Logger logger = LoggerFactory.getLogger(ConfigClientAppClientBootStrap.class);
	

	public static void main(String[] args) throws Exception{
		
//		ApplicationContext applicationContext = SpringApplication.run(AppClientBootStrap.class, args);
		//SpringContextUtil.setApplicationContext(applicationContext);
		new SpringApplicationBuilder(ConfigClientAppClientBootStrap.class).web(true).run(args);
		
		logger.info("config client 启动成功");
		final CountDownLatch latch = new CountDownLatch(1);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				latch.countDown();
			}
		});
		latch.await();
	}

}
