package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 安全授权中心
 * @author zghdo
 *
 */
@SpringBootApplication
@EnableAuthorizationServer
public class SecurityApplication {
	private static Logger logger = LoggerFactory.getLogger(SecurityApplication.class);
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(SecurityApplication.class).web(true).run(args);
		logger.info("spring cloud 安全授权中心启动成功!");
	}
}
