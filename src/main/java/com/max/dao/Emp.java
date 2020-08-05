package com.max.dao;

import java.io.Serializable;

public class Emp  implements Serializable {
    /**
     * 序列化 当一个类的对象要进行网络传输或者存储， 二进制
     * 实体类在mybatis中实现序列化的原因 在xml映射器中做增删查改时 使用的参数类型 很多时候是实体类对象
     * 实际上都是修改数据库，实际上就是把一个对象在硬盘上做修改，这个对象必须是实现序列化的
     */

    public Integer id;
    public String eName;
    public String sex;
    public String eNo;
    public String dId;
    public Dept dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", eName='" + eName + '\'' +
                ", sex='" + sex + '\'' +
                ", eNo='" + eNo + '\'' +
                ", dId='" + dId + '\'' +
                ", dept=" + dept +
                '}';
    }
}
