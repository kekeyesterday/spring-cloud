package org.springcloud.service.consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController("test")
public class ConsumerController {
    @Autowired
    private ComputeClient computeClient;
    
    @GetMapping(value = "/add/{a}+{b}")
   // @HystrixCommand(fallbackMethod = "hiError")
    public String add(@PathVariable("a")Integer a,@PathVariable("b")Integer b) {
    	String result = computeClient.add(a, b).toString();
        return result;
    }
    
    
//    public String hiError(Integer a,Integer b) {
//    	String msg = "hi,"+a+",sorry,error!";
//    	System.out.println("======msg::" + msg);
//    	//String result = restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a={a}&b={b}", String.class,a,b).getBody();
//        return msg;
//    }
    

}
