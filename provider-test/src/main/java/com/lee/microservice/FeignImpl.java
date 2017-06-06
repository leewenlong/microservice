package com.lee.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiWenLong
 * @version 3.0
 * @date: 2017/5/31
 * @Copyright (C) 2008-2017 oneapm.com. all rights reserved.
 */
@RestController
public class FeignImpl {
    @Autowired
    public FeignInterface feign;

    @RequestMapping(method = RequestMethod.GET, path = "/test/{id}")
    public String test(@PathVariable("id") String id) {
        return this.feign.user(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String test() {
        return this.feign.test();
    }

}
