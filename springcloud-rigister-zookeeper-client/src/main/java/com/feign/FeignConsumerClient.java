package com.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feign.FeignConsumerClient.HstrixClient;

@FeignClient(value="zk-service-supply",fallback=HstrixClient.class)
public interface FeignConsumerClient {
    
    @RequestMapping(value = "/getUserInfo", method = {RequestMethod.GET})
    @ResponseBody
    public String getUserInfo(@RequestParam(value="id") Long id) ;
    
    @Component
    class HstrixClient implements FeignConsumerClient{

		@Override
		public String getUserInfo(Long id) {
			return "error";
		}
    	
    }

}

