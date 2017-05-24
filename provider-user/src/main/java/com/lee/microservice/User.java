package com.lee.microservice;

import java.io.Serializable;

/**
 * @author LiWenLong
 * @version 3.0
 * @date: 2017/5/24
 * @Copyright (C) 2008-2017 oneapm.com. all rights reserved.
 */
public class User implements Serializable{

    private String id;
    private int age;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
