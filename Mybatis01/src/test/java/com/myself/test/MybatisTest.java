package com.myself.test;

import com.myself.Dao.IUserDao;
import com.myself.Dao.impl.UserDaoImpl;
import com.myself.MybatisUtils;
import com.myself.domain.User;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
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
import java.util.Map;

/*
    Mybatis入门案例
*/
public class MybatisTest {

    @Test //查询所有
    public void findAll1() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);  //SqlSessionFactory 是一个接口,不能new
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象                                    //4.(用实现类的方式)使用工厂创建Dao对象;方法3和4都去掉,用这个4代替即可
        IUserDao userDao = session.getMapper(IUserDao.class);                    //IUserDao userDao = new UserDaoImpl(factory);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();  //IUserDao接口中finAll()方法返回值是List<>类型
        for(User user:users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        is.close();
    }

    @Test //条件查询
    public void findOne() throws IOException{
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);

        User user = userDao.findUserById(41);
            System.out.println(user);
        session.close();
        is.close();
    }

    @Test//模糊查询
    public void findLike() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        List<User> user = userDao.findUserLike("%张%");
        for (User users:user){
            System.out.println(users);
        }

    }

    @Test //增删改需要提交事务,Mybatis默认不是自动提交事务的.解决的办法一是在openSession() 的括号里写true, 设定自动提交事务, 一是在代码中加入sqlSession.commit()
    public void insertTest01() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);

        int res = userDao.addUser(new User(41,"示范",new Date(),"男","杭州西湖"));
        if (res > 0 ){
            System.out.println("插入成功");
        }
        //提交事务
        session.commit();

        session.close();
        is.close();
    }

    @Test//使用Map
    public void insertTest02() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("unknowId",45);
        map.put("unknowUsername","马普");
        map.put("unknowBirthday",new Date());
        map.put("unknowsex","男");
        map.put("unknowAddress","岳阳楼");

        int i = userDao.addUser2(map);
        if(i == 1){
            System.out.println("Map方法添加成功");
        }
        session.commit();
        session.close();
    }

    @Test
    public void UpdateTest01() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);

        int i = userDao.updateUser(new User(41,"更改",new Date(),"女","杭州下沙"));
        if(i==1){
            System.out.println("成功修改");
        }
        session.commit();

        session.close();
        is.close();
    }

    @Test
    public void DeleteTest01() throws IOException {
        //利用自己写的工具类MybatisUtils 快捷调用
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        int i = userDao.deleteUser(41);
        if(i==1){
            System.out.println("删除成功");
        }
        session.commit();
    }
}
