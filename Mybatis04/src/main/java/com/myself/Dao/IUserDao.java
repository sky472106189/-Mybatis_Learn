package com.myself.Dao;

import com.myself.domain.User;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

/*
    用户持久层接口
*/

public interface IUserDao {

    //根据ID查
    User findUserById(int ID);

    //分页查询
    List<User> getUserByLimit(Map<String,Integer> map);

    //分页2
    List<User> getUserByRowBounds();


}
