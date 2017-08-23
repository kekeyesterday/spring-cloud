package org.springcloud.service.supply.hystix;

import org.junit.Test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldCommand extends HystrixCommand<String> {

    public HelloWorldCommand(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(name)));
    }

    @Override
    protected String run() throws Exception {
        System.out.println("run success " + Thread.currentThread().getName());
        return "run success " + Thread.currentThread().getName();
    }
    
    
    @Test
    public void helloWorldCommand() {
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("klov");
        String result = helloWorldCommand.execute();
        System.out.println("【HelloWorldCommand】 result = "+result);
    }
}
