package com.myself.test;


import com.myself.Dao.UserMapper;
import com.myself.domain.User;
import com.myself.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    动态SQL
*/
public class MybatisTest {

    @Test//一级缓存
    public void Test01() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User byId = mapper.findById(42);
        System.out.println(byId);

        System.out.println("===============================");

        User byId2 = mapper.findById(42);
        System.out.println(byId2);

        System.out.println(byId==byId2);

        sqlSession.close();
    }
    @Test//二级缓存
    public void Test02() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSession();
        SqlSession sqlSession2 = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User byId = mapper.findById(42);
        System.out.println(byId);
        sqlSession.close();

        System.out.println("======================");

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User byId2 = mapper2.findById(42);
        System.out.println(byId2);

    }



}

