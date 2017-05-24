package com.lee.microservice;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author LiWenLong
 * @version 3.0
 * @date: 2017/5/24
 * @Copyright (C) 2008-2017 oneapm.com. all rights reserved.
 */
@Mapper
public interface UserDao {

    User getById(String id);

    User getByName(String name);
}
