import com.max.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

public class EmpAndDeptTest {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("myBatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Emp> res = sqlSession.getMapper(DeptMapper.class).select();
        System.out.println(res);



        sqlSession.commit();

        reader.close();
        sqlSession.close();
    }
}
