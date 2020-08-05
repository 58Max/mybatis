package com.max.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParamMapper {
    public List<Map> select( Integer num);
    public List<Map> select1(String name);
    public List<Map> select2(@Param("name") String name);
    public List<Map> select3(String name);
 }
