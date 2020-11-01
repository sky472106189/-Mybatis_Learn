import com.myself.dao.TeacherMapper;
import com.myself.pojo.Teacher;
import javafx.application.Application;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test01() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        is.close();
        SqlSession sqlSession = factory.openSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.findAll();
        for(Teacher s:teachers){
            System.out.println(s);
        }

        sqlSession.close();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        TeacherMapper teacherMapper = context.getBean("teacherMapper", TeacherMapper.class);
        List<Teacher> teachers = teacherMapper.findAll();
        for(Teacher s:teachers){
            System.out.println(s);
        }
    }

}
