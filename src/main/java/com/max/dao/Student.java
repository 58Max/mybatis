package com.max.dao;

import org.apache.ibatis.annotations.Insert;

public class Student {
    public Integer id;
    public String name;
    public Integer age;
    public String sex;
    public String classes;
    public Integer servlet;
    public Integer jsp;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getServlet() {
        return servlet;
    }

    public void setServlet(Integer servlet) {
        this.servlet = servlet;
    }

    public Integer getJsp() {
        return jsp;
    }

    public void setJsp(Integer jsp) {
        this.jsp = jsp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", classes='" + classes + '\'' +
                ", servlet=" + servlet +
                ", jsp=" + jsp +
                '}';
    }
}
