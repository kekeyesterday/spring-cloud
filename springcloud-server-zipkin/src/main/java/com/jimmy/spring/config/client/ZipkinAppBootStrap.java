package com.jimmy.spring.config.client;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import zipkin.server.EnableZipkinServer;



@SpringBootApplication
@EnableZipkinServer
public class ZipkinAppBootStrap {
	private static Logger logger = LoggerFactory.getLogger(ZipkinAppBootStrap.class);
	

	public static void main(String[] args) throws Exception{
		
		
//		ApplicationContext applicationContext = SpringApplication.run(AppClientBootStrap.class, args);
		//SpringContextUtil.setApplicationContext(applicationContext);
		new SpringApplicationBuilder(ZipkinAppBootStrap.class).web(true).run(args);
		
		logger.info("ZipkinServer 启动成功");
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
