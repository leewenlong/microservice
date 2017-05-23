package com.lee.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiWenLong
 * @version 3.0
 * @date: 2017/5/23
 * @Copyright (C) 2008-2017 oneapm.com. all rights reserved.
 */
@RestController
@RefreshScope
public class UserController {
    @Value("${load}")
    private String load;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(method= RequestMethod.GET,path = "/")
    public String home(){
        return "hello spring boot";
    }

    @RequestMapping(method= RequestMethod.GET,path = "/user/{id}")
    public String user(@PathVariable String id){
        return "this is a user result id = "+ id;
    }

    @RequestMapping(method= RequestMethod.GET,path = "/load")
    public String load(){
        return load;
    }
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}
