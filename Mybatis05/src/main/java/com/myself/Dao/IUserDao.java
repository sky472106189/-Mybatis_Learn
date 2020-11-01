package com.myself.Dao;

import com.myself.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/*
    用户持久层接口
*/

public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{idflag}")
    User findById(@Param("idflag") int 随便写);
    //假如方法存在多个参数,根据ID和NAME查询
/*    @Select("select * from user where id = #{id} and name = #{name}")
    User findByIdAndName(@Param("id") int id,@Param("name") String name);*/

    @Insert("insert into user(id,username,birthday,sex,address) values (#{id},#{username},#{birthday},#{sex},#{address})")
    int addUser(User user);

    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id2}")
    int deleteUser(@Param("id2") int random);
}
