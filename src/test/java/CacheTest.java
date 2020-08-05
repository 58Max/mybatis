import com.max.dao.DeptMapper;
import com.max.dao.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CacheTest {
    public static void main(String[] args) throws IOException {
        Reader reader = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession session = null;
        SqlSession session1 = null;

        reader = Resources.getResourceAsReader("myBatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        session = sqlSessionFactory.openSession();
        session1 = sqlSessionFactory.openSession();
        System.out.println("-------------------------------------------");
        List<Emp> res = session.getMapper(DeptMapper.class).select();
//      第一次查询之后必须提交,才能把结果放到二级缓存中
        session.commit();

        System.out.println("-------------------------------------------");
        session1.getMapper(DeptMapper.class).select();
        System.out.println("-------------------------------------------");


        reader.close();
        session.close();
        session1.close();
    }
}
