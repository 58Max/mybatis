package com.max.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

/**
 * 纯注解的接口映射器
 */


@CacheNamespace//开启当前接口的二级缓存 没有配置默认不开启二级缓存 开启之后 当前接口的所有方法都可以使用二级缓存
public interface AnnotationsMapper {

	/**
	 * @select  代表 xml 的 select 标签
	 * 当接收结果的实体类的属性与查询的字段完全相同时 我们就不用去定义 实体类属性与查询表的字段映射
	 * 这个和xml映射器+接口的案例思路相同
	 * @return  返回值定义取决于查询语句的返回值
	 */


	/**
	 *
	 * @param 当实体类中的属性与查询表中的字段不完全一致时 我们需要写映射关系
	 * @return 使用 @results{ value={@result()}} 就像在xml文件中定义映射关系一样
	 * @Results 相当于 resultMap标签 value={} 中就是实体类与字段表的关系映射
	 * 如果属性对应的字段是主键 我们需要配置 id=true 属性
	 */
	@Select("select * from user")
	public List<User> selelctUsers();


	@Select("select * from student where id = #{id}")
	@Results(
			value={
					@Result(id=true,property="id",column="id"),
					@Result(property="age", column="age"),
					@Result(property="name", column="name"),
					@Result(property="classes", column="class"),
					@Result(property="servlet", column="servlet"),
					@Result(property="jsp", column="jsp")
			})

	//接口开启之后 接口的方法默认都是开启了二级缓存
	// 我们可以使用@Options(useCache = false) 关闭当前注解对应方法的二级缓存
	@Options(useCache = false)
	public Student selelctStuById(Integer id);
	
	@Insert("insert into student(id,name) values (#{id},#{name})")
	public int insertStu(Student stu);
	
	@Update("update student set name = #{name} where id = #{id}")
	public int updateStu(Student stu);
	
	@Delete("delete from student where id = #{id}")
	public int deleteStu(Student stu);

	/**
	 * 通过注解的方式实现多表关联查询
	 * 当前是一对多查询
	 * 注解把查询做了拆分
	 * 先把主表查询拿出来变成单表查询
	 * 再实现一个子查询：关联表部分的查询
	 * 在接口中定义两个方法分别对应两个sql语句
	 * 在主表的结果实体类与表的映射中 再配置员工的集合属性时 去指明怎么查询怎么传递参数
	 * @return
	 */

	/**
	 * 主表查询 查询主表字段
	 * @return
	 */
	@Select("SELECT "
		+ "d.id did,d.d_name,d.d_desc,d.d_no"
		+ " FROM dept d ")
	@Results(
			value={
					@Result(id=true,property="id",column="did"),
					@Result(property="dName", column="d_name"),
					@Result(property="dDesc", column="d_desc"),
					@Result(property="dNo", column="d_no"),
					/**
					 * 主表的查询与关联表的子查询通过下面的配置结合起来
					 * property="emps" 主表实体类的属性名
					 * 属性是集合 则需要使用many=@Many(select="com.max.dao.AnnotationsMapper.selectEmpByDid")
					 * select="" 里面的值写的是子查询接口的全名称
					 * 这样就指定了many对应的子查询
					 * column="did"  指定主表的哪个个字段的值当做参数传递给子查询
					 * many使用在一对多查询中
					 */
					@Result(property="emps", column="did", many=@Many(select="com.max.dao.AnnotationsMapper.selectEmpByDid"))
			})
	public List<Dept> selectDepts();

	/**
	 * 子查询 根据部门id查询员工
	 * @param id
	 * @return
	 */
	
	@Select("SELECT "
			+ "e.id,e.e_name,e.sex,e.e_no,e.d_id"
			+ " FROM emp e where e.d_id = #{id}")
	@Results(
			value={
					@Result(id=true,property="id",column="id"),
					@Result(property="eName", column="e_name"),
					@Result(property="sex", column="sex"),
					@Result(property="eNo", column="e_no"),
					@Result(property="dId", column="d_id")
			})
	public List<Emp> selectEmpByDid(Integer id);

	/**
	 * 多对一查询
	 * 和实现一对多类似
	 * 先做主表查询
	 * 再做关联表查询
	 * @param id
	 * @return
	 */
	@Select("SELECT "
			+ "d.id,d.d_name,d.d_desc,d.d_no"
			+ " FROM dept d where d.id = #{id}")
	@Results(
			value={
					@Result(id=true,property="id",column="id"),
					@Result(property="dName", column="d_name"),
					@Result(property="dDesc", column="d_desc"),
					@Result(property="dNo", column="d_no")
			})
	public Dept selectDeptById(Integer id);
	
	@Select("SELECT "
			+ "e.id,e.e_name,e.sex,e.e_no,e.d_id"
			+ " FROM emp e ")
	@Results(
			value={
					@Result(id=true,property="id",column="id"),
					@Result(property="eName", column="e_name"),
					@Result(property="sex", column="sex"),
					@Result(property="eNo", column="e_no"),
					@Result(property="dId", column="d_id"),
					/**
					 * 多对一查询时
					 *  property="dept" 实体类的属性名
					 *  这个映射需要配置one=@One...
					 *  one代表当前配置的属性是单个对象 不是集合类型
					 */
					@Result(property="dept", column="d_id", one=@One(select="com.max.dao.AnnotationsMapper.selectDeptById"))
			})
	public List<Emp> selectEmps();
}
