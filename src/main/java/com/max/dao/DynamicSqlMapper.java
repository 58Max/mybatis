package com.max.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
     public int insert(Student stu);
     public List<Map>  selectStu(Student stu);
     public List<Map> selectByAge(@Param("age") Integer age);
     public int updateStu(Student stu);
     public List<Map> selectStuByIds(Integer[] ids);
     public int insertStus(List<Student> stu);
}
