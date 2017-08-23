package com.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("feign")
public class ClientController {

    @Autowired
    private FeignConsumerClient feignConsumerClient;

    @RequestMapping(value = "/getUserInfo", method = {RequestMethod.GET})
    @ResponseBody
    public String getUserInfo(@RequestParam(value="id") Long id) {
    	try {
    		return feignConsumerClient.getUserInfo(id);
		} catch (Exception e) {
			System.out.println("============error===========");
			e.printStackTrace();
		}
        return null;
    }
}


