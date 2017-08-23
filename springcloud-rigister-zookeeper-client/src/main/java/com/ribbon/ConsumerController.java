package com.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController("/ribbon")
public class ConsumerController {
	
    @Autowired
    private ComputeService computeService;
    
    @RequestMapping(value = "/getUserInfo",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hiError")
    public String getUserInfo(@RequestParam(value = "id")Integer id) {
    	String result = null;
    	try {
    		result = computeService.getUserInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        return result;
    }
    
    
    public String hiError(Integer a) {
    	String msg = "hi,"+a+",sorry,error!";
    	System.out.println("======msg::" + msg);
    	//String result = restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a={a}&b={b}", String.class,a,b).getBody();
        return msg;
    }

}
