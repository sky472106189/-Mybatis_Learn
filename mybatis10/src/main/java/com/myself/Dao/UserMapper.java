package com.myself.Dao;

import com.myself.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //根据ID查
    User findById(@Param("id") int id);
}
