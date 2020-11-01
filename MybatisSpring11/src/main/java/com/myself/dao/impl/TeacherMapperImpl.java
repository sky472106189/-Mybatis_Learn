package com.myself.dao.impl;

import com.myself.dao.TeacherMapper;
import com.myself.pojo.Teacher;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class TeacherMapperImpl implements TeacherMapper {

    private SqlSessionTemplate sqlSession;
    //使用Spring注入
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Teacher> findAll() {
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        return mapper.findAll();
    }
}
