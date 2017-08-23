package com.jimmy.spring.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class TestController {
	@Value("${foo:defalut}")
	private String foo;

	@Value("${spring.cloud.test1:defalut}")
	private String flag;

	@Value("${zuul.routes.api-a.serviceId:defalut}")
	private String test;

	@RequestMapping("/hi")
	public String from() {
		String rmsg = foo + "||" + flag + "||====||" + test;
		return rmsg;
	}
}
