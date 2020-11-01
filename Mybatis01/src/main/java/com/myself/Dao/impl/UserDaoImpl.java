package com.myself.Dao.impl;

import com.myself.Dao.IUserDao;
import com.myself.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/*
    IUserDao接口的实现类(证明Mybatis是支持写Dao实现类的)

    注意:写实现类对Mybatis没有意义,因为不写实现类也能实现功能
*/
public class UserDaoImpl implements IUserDao{

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll(){
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法
        List<User> list= session.selectList("com.myself.Dao.IUserDao.findAll"); //双引号里面的值不要直接写SQL语句,这样提高了耦合度,
                                                                                   //而且我们的配置文件也没发挥作用,所以要引入xml文件
                                                                                   //并且调用相关方法
        session.close();
        //返回查询结果集
        return list;
    }

    public User findUserById(int id) {
        return null;
    }

    public int addUser(User user) {
        return 0;
    }

    public int addUser2(Map<String, Object> map) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public int deleteUser(int Id) {
        return 0;
    }

    public List<User> findUserLike(String value) {
        return null;
    }
}
