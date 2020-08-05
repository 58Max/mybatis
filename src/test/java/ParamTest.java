import com.max.dao.DeptMapper;
import com.max.dao.Emp;
import com.max.dao.ParamMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class ParamTest {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("myBatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**
         * 对于获取数字类型的参数来说 #号不需要写参数注解 $需要写参数注解
         * #解析为占位符  $直接硬拼
         */

//        List<Map> res = sqlSession.getMapper(ParamMapper.class).select(2);
        /**
         * 对于获取字符串类型参数 使用#和$ 效果不一样
         * #{}是解析成占位符 参数值替换占位符位置的时候,是用单引号括起来的
         * ${} 直接硬拼  没有单引号 当参数作为条件所以报错
         */

//        List<Map> res = sqlSession.getMapper(ParamMapper.class).select1("MASIWEI");


//        List<Map> res = sqlSession.getMapper(ParamMapper.class).select2("MASIWEI");

        List<Map> res = sqlSession.getMapper(ParamMapper.class).select3("%MASIWEI%");

        System.out.println(res);



        sqlSession.commit();

        reader.close();
        sqlSession.close();
    }
}
