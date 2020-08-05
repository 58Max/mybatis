import com.max.dao.DynamicSqlMapper;
import com.max.dao.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicSqlTest {
    public static void main(String[] args){

        Reader reader = null;
        SqlSession session = null;

        try {
            reader = Resources.getResourceAsReader("myBatis-config.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            session = sqlSessionFactory.openSession();

            Student stu = new Student();
            stu.setId(1);
            stu.setName("MASIWEI");

//
//            int res = session.getMapper(DynamicSqlMapper.class).insert(stu);
//            System.out.println(res);


//            List<Map> res = session.getMapper(DynamicSqlMapper.class).selectStu(stu);
//            System.out.println(res);

//            List<Map> res = session.getMapper(DynamicSqlMapper.class).selectByAge(18);
//            System.out.println(res);

//            int res = session.getMapper(DynamicSqlMapper.class).updateStu(stu);
//            System.out.println(res);

//            Integer[] ids = new Integer[]{1,2};
//
//            List<Map> res = session.getMapper(DynamicSqlMapper.class).selectStuByIds(ids);
//            System.out.println(res);

            List<Student> list = new ArrayList<Student>();
            Student s1 = new Student();
            s1.setId(5);
            s1.setName("批量操作一");
            Student s2 = new Student();
            s2.setId(6);
            s2.setName("批量操作二");
            list.add(s1);
            list.add(s2);

            int res = session.getMapper(DynamicSqlMapper.class).insertStus(list);
            System.out.println(res);

            session.commit();

        } catch (IOException e) {
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
