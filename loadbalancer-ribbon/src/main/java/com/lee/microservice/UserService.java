package com.lee.microservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiWenLong
 * @version 3.0
 * @date: 2017/5/23
 * @Copyright (C) 2008-2017 oneapm.com. all rights reserved.
 */
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "error")
    public String user(@PathVariable String id) {
        return restTemplate.getForEntity("http://provider-user/user/"+id, String.class).getBody();
    }

    public String error(String id){
        return "error========="+id;
    }

    @HystrixCommand(fallbackMethod = "getByIdError")
    public User getById(@PathVariable String id) {
        return restTemplate.getForEntity("http://provider-user/users/"+id, User.class).getBody();
    }


    public User getByIdError(@PathVariable String id) {

        User user = new User();
        user.setAge(-1);
        user.setId("-1");
        user.setName("error");
        return user;
    }

}
