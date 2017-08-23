package org.springcloud.service.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    private ComputeService computeService;
    
    @GetMapping(value = "/add")
    @HystrixCommand(fallbackMethod = "hiError")
    public String add(Integer a,Integer b) {
    	String result = restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a={a}&b={b}", String.class,a,b).getBody();
        return result;
    }
    
    
    public String hiError(Integer a,Integer b) {
    	String msg = "hi,"+a+",sorry,error!";
    	System.out.println("======msg::" + msg);
    	//String result = restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a={a}&b={b}", String.class,a,b).getBody();
        return msg;
    }
    
    @GetMapping(value = "/hystrixAdd")
    public String hystrixAdd() {
    	String result = computeService.addService();
        return result;
    }
}
