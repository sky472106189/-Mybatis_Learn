package com.myself.test;

import com.myself.Dao.IUserDao;
import com.myself.utils.MybatisUtils;
import com.myself.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/*
    Mybatis使用注解方式(不是主流)
*/
public class MybatisTest {

    @Test //查询所有
    public void findAll1() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        //底层主要应用反射,
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
    }

    @Test//根据id查询
    public void Testo2() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        User user = userDao.findById(42);
        System.out.println(user);

        session.close();
    }

    @Test//新增
    public void Test3() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        userDao.addUser(new User(41,"老四",new Date(),"男","冥王星"));

        session.close();
    }

    @Test//修改
    public void Test4() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        userDao.updateUser(new User(41,"老吴",new Date(),"男","地球"));

        session.close();
    }

    @Test//删除
    public void Test5() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        userDao.deleteUser(41);

        session.close();
    }

}
