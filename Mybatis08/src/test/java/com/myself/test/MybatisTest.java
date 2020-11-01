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
    @Test //查询老师的信息以及旗下学生信息
    public void Test01() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

        Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);

        session.close();
    }

    @Test //查询老师的ID查旗下学生信息
    public void Test02() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

        Teacher teacher = teacherMapper.getTeacher2(1);
        System.out.println(teacher);

        session.close();
    }
}
