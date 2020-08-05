import com.max.dao.Student;
import com.max.dao.StudentCURDIn;
import com.max.dao.User;
import com.max.dao.UserIn;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StudentCURDTest {

    public static void main(String[] args)  {

        Reader reader = null;
        SqlSession session = null;
        try {
            reader = Resources.getResourceAsReader("myBatis-config.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            session = sqlSessionFactory.openSession();

            //增加
//            Student stu = new Student();
//            stu.setId(24);
//            stu.setName("MASIWEI");
//
//            int res = session.getMapper(StudentCURDIn.class).insert(stu);
//            System.out.println(res);

            //修改
//            Student stu = new Student();
//            stu.setId(24);
//            stu.setName("DZKnow");
//            stu.setAge(25);
//
//            int res =  session.getMapper(StudentCURDIn.class).updata(stu);
//            System.out.println(res);

//            //删除
//            Student stu = new Student();
//            stu.setId(24);
//
//            int res = session.getMapper(StudentCURDIn.class).delete(stu);
//            System.out.println(res);

//            //单一查询
//
//            Student stu = new Student();
//            stu.setId(37);
//
//            Student res = session.getMapper(StudentCURDIn.class).selectById(stu);
//            System.out.println(res.toString());

//
//            //多查询
//            List<Student> res = session.getMapper(StudentCURDIn.class).select();
//            System.out.println(res);


//            List<User> res = session.getMapper(UserIn.class).selectUser();
//            System.out.println(res);

            User res = session.getMapper(UserIn.class).selectById(2);
            System.out.println(res.toString());

            session.commit();

        } catch (IOException e) {
            e.printStackTrace();
            session.rollback();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        session.close();


    }
}
