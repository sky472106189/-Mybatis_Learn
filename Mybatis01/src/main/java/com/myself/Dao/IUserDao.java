package com.myself.Dao;

import com.myself.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    用户持久层接口
*/

public interface IUserDao {

    //查询所有
    List<User> findAll();

    //新增一个用户
    int addUser(User user); //int代表的是变动的数据,1就表示1行数据变动,2就表示2行数据变动.

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int Id);

    User findUserById(int i);

    List<User> findUserLike(String s);

    int addUser2(Map<String, Object> map);
}
