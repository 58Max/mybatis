package com.max.dao;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {


    public Integer id;
    public String dName;
    public String dNo;
    public String dDesc;
    public List<Emp> emps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdNo() {
        return dNo;
    }

    public void setdNo(String dNo) {
        this.dNo = dNo;
    }

    public String getdDesc() {
        return dDesc;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dName='" + dName + '\'' +
                ", dNo='" + dNo + '\'' +
                ", dDesc='" + dDesc + '\'' +
                ", emps=" + emps +
                '}';
    }
}
