package com.max.dao;

import java.io.Serializable;

/*
 最好实现序列化  对实体类实现增删改查操作时 必须实现序列化的接口这是mybatis的特点
 */
public class User implements  Serializable{

    public Integer id ;
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
