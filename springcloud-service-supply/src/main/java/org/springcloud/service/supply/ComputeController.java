package org.springcloud.service.supply;

import org.apache.log4j.Logger;
import org.springcloud.service.supply.hystix.HelloWorldCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class ComputeController {
    private final Logger logger = Logger.getLogger(getClass());
	@Value("server.port")
	static String serverPort;
    @Autowired
    private DiscoveryClient client;
    
    
    
    
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hiError")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("=========serverPort::============" + serverPort);
        logger.info("/add, host:" + instance.getHost() + ",port:" +  instance.getPort() + " , service_id:" + instance.getServiceId() + ", result:" + r);
        
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("klov");
        String result = helloWorldCommand.execute();
        System.out.println("【HelloWorldCommand】 result = "+result);
        
        try {
			Thread.sleep(10000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int t = 10/0;
        return r;
    }
    
    
    public Integer hiError(Integer a,Integer b) {
    	String msg = "error error error!";
    	System.out.println("======msg::" + msg);
        return -1;
    }
    
    
    public  String sayHiFromClientOne(@RequestParam(value = "name") String name){
    	ServiceInstance instance = client.getLocalServiceInstance();
    	String msg = "Hi, " + name;
    	
    	logger.info(msg + "=======sayHiFromClientOne, host:" + instance.getHost() + ",port:" +  instance.getPort() + " , service_id:" + instance.getServiceId());
    	return null;
    }
}
