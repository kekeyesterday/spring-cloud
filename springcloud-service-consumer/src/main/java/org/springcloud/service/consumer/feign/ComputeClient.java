package org.springcloud.service.consumer.feign;

import org.springcloud.service.consumer.feign.ComputeClient.HystrixComputeService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="compute-service",fallback=HystrixComputeService.class)
public interface ComputeClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
    
    @Component
    class HystrixComputeService implements ComputeClient{

		@Override
		public Integer add(Integer a, Integer b) {
			String msg = "error a:" + a + "==== b:" +b;
			System.out.println("=================msg::" + msg);
			return -100;
		}
    	
    }

}


