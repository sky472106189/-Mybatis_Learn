package com.myself.Dao;

import com.myself.domain.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> findAll();

    @Select("select * from teacher where id = #{realId}")
    Teacher findById(@Param("realId") int id);
}
