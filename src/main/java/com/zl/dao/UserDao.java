package com.zl.dao;

import com.zl.domain.User;
import com.zl.mybatis.annotation.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAll();
}
