import com.max.dao.Student;
import com.max.dao.StudentIn;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class XMLAndANOTest {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("myBatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student stu = new Student();
        stu.setId(22);
        stu.setName("58max");

        int res = sqlSession.getMapper(StudentIn.class).insert(stu);
        sqlSession.commit();

        reader.close();
        sqlSession.close();
    }
}
