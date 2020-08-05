package com.max.dao;

import org.apache.ibatis.annotations.Insert;
/*
  接口与注解方式混合
 */
public interface StudentIn {
    /*
     @Insert相对应xml映射器的insert标签
     @Insert("")里面的字符串参数就是insert标签的SQL语句
     */
    @Insert("insert into student(id,name) values (#{id},#{name});")
    public int insert(Student stu);
}
