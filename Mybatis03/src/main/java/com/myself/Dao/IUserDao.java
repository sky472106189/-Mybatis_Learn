package com.myself.Dao;

import com.myself.domain.User;
import java.util.List;
import java.util.Map;

/*
    用户持久层接口
*/

public interface IUserDao {

    //根据ID查
    User findUserById(int ID);

}
