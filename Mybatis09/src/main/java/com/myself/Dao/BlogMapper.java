package com.myself.Dao;

import com.myself.domain.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Blog> findALL();

    //XML方法
    int insertBlog(Blog blog);

    //注解
    @Insert("insert into blog(id, title, author, creat_time, views) VALUES (#{id},#{title},#{author},#{creatTime},#{views})")
    int insertBlog2(Blog blog);

    //查询博客(动态SQL IF)
    List<Blog> findBlogIF(Map map);

    //查询博客(动态SQL choose)
    List<Blog> findBlogChoose(Map map);

    //更新博客(动态SQL set)
    int updateBlog(Map map);
}
