package com.max.dao;

import com.max.dao.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentCURDIn {
    /*
     新增
     */
    @Insert("insert into student(id,name) values (#{id},#{name});")
    public int insert(Student stu);

    /*
    修改
     */
    @Update("update student set name = #{name},age = #{age} where id = #{id};")
    public int updata(Student stu);

    /*
    删除
     */
    @Delete(" delete from student where id = #{id};")
    public int delete(Student stu);

    /*
    根据ID查询
     */
    @Select("select * from student where id = #{id};")
    public Student selectById(Student stu);

    /*
    查询多条数据
     */
    @Select("select * from student;")
    public List<Student> select();

}
