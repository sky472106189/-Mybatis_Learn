package com.myself.test;

import com.myself.Dao.StudentMapper;
import com.myself.Dao.TeacherMapper;
import com.myself.domain.Student;
import com.myself.domain.Teacher;
import com.myself.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/*
    多对一的数据库实例(student--teacher)
*/
public class MybatisTest {
    @Test //查询所有老师
    public void Test01() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

        List<Teacher> teacherList = teacherMapper.findAll();
        Iterator<Teacher> it = teacherList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test //根据ID查老师
    public void Test02() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

        Teacher teacher = teacherMapper.findById(1);
        System.out.println(teacher);

        session.close();
    }

    @Test
    public void  Test03() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> list = mapper.getStudent2();
        for(Student s :list){
            System.out.println(s);
        }

        session.close();
    }

}
