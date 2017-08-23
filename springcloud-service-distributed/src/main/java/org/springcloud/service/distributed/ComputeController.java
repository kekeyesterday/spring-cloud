package org.springcloud.service.distributed;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ComputeController {
    private final Logger logger = Logger.getLogger(getClass());
	@Value("server.port")
	static String serverPort;
    @Autowired
    private DiscoveryClient client;
    
    
    
    
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("=========serverPort::============" + serverPort);
        logger.info("/add, host:" + instance.getHost() + ",port:" +  instance.getPort() + " , service_id:" + instance.getServiceId() + ", result:" + r);
        int t = 10/0;
        return r;
    }
    
    public  String sayHiFromClientOne(@RequestParam(value = "name") String name){
    	ServiceInstance instance = client.getLocalServiceInstance();
    	String msg = "Hi, " + name;
    	
    	logger.info(msg + "=======sayHiFromClientOne, host:" + instance.getHost() + ",port:" +  instance.getPort() + " , service_id:" + instance.getServiceId());
    	return null;
    }
}
