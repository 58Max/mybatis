import com.max.dao.AnnotationsMapper;
import com.max.dao.Student;
import com.max.dao.StudentIn;
import com.max.dao.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    Reader reader = null;
    SqlSessionFactory sqlSessionFactory = null;

    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public void commit(SqlSession sqlSession){
        sqlSession.commit();
    }
    public static void main(String[] args) throws IOException {
//        Reader reader = Resources.getResourceAsReader("myBatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//
////        List<User> res= sqlSession.getMapper(AnnotationsMapper.class).selelctUsers();
//
//
//          System.out.println(sqlSession.getMapper(AnnotationsMapper.class).selectDepts());
//
//
//        sqlSession.commit();
//
//        reader.close();
//        sqlSession.close();




    }
}
