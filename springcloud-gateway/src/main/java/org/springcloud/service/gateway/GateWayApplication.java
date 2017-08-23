package org.springcloud.service.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springcloud.service.gateway.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class GateWayApplication {
	private static Logger logger = LoggerFactory.getLogger(GateWayApplication.class);
	public static void main(String[] args) {
		new SpringApplicationBuilder(GateWayApplication.class).web(true).run(args);
		logger.info("服务网关启动成功");
	}
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
