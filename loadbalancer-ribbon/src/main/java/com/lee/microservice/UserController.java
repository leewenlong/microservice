package com.lee.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiWenLong
 * @version 3.0
 * @date: 2017/5/23
 * @Copyright (C) 2008-2017 oneapm.com. all rights reserved.
 */
@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String user(@PathVariable String id) {
        return restTemplate.getForEntity("http://provider-user/user/"+id, String.class).getBody();
    }
}
