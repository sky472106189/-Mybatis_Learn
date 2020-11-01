package com.myself.Dao;

import com.myself.domain.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    //获取该老师的信息,同时旗下所有学生的信息
    //老师对学生是:一对多的关系
    //所以返回类型是Teacher一个
    //值得注意:因为一对多,所以老师里面有一个学生集合
    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);

}