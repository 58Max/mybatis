package com.max.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserIn {

    @Select("select * from user;")
    public List<User> selectUser();

    @Select("select * from user where id = #{id};")
    public User selectById(Integer id);
}
