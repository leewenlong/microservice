package com.lee.microservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LiWenLong
 * @version 3.0
 * @date: 2017/5/31
 * @Copyright (C) 2008-2017 oneapm.com. all rights reserved.
 */
@FeignClient(name = "provider-user")
public interface FeignInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String test();

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public String user(@PathVariable("id") String id);
}
