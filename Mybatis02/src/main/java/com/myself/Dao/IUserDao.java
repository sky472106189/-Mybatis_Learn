package com.myself.Dao;

import com.myself.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
    用户持久层接口
*/

public interface IUserDao {

    //查询所有
    //@Select("select * from user ")  注解方式加上这一句,并且在主配置文件SqlMapConfig.xml中修改Mapper标签
    List<User> findAll();

    //新增一个用户
    int addUser(User user); //int代表的是变动的数据,1就表示1行数据变动,2就表示2行数据变动.

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

}
