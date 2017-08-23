package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vo.UserDto;

@RestController
public class ComputeController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/getUserInfo", method = {RequestMethod.GET})
    @ResponseBody
    public UserDto getUserInfo(@RequestParam(value="id") Long id) {
    	System.out.println("===========zk2222222=============");
        ServiceInstance instance = client.getLocalServiceInstance();
        UserDto dto = new UserDto();
        dto.setId(id);
        dto.setUserName("scott");
        dto.setAge(100);
        return dto;
    }

}

