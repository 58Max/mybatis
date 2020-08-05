import com.max.dao.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class XMLSqlTest {
    public static void main(String[] args) throws IOException {
        //加载主配置文件，配置文件中有数据库连接的信息，映射器文件信息
        Reader reader = Resources.getResourceAsReader("myBatis-config.xml");


        //创建SqlSession工厂
        SqlSessionFactory sqlSessionFactory  =  new SqlSessionFactoryBuilder().build(reader);

        //得到SqlSession对象 这个对象是操作映射器的对象
        SqlSession session = sqlSessionFactory.openSession();

        Student stu = new Student();
        stu.setId(37);
        stu.setName("xml");

        //提交SQL
        /*
         第一个参数 定位映射器 namespace+id
         第二个参数 传递到映射器的参数 操作的对象
         */
        int res = session.insert("com.max.mapper.StudentMapper.insert01",stu);
        System.out.println(res);

        //提交session
        session.commit();

        //关闭连接
        reader.close();
        session.close();


    }
}
