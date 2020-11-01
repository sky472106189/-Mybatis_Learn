package com.myself.test;


import com.myself.Dao.BlogMapper;
import com.myself.domain.Blog;
import com.myself.utils.IdUtils;
import com.myself.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
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

    @Test
    public void Test01() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession("SqlMapConfig.xml");
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogs = mapper.findALL();
        for (Blog blog : blogs){
            System.out.println(blog);
        }
    }

    @Test
    public void Test02() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession("SqlMapConfig.xml");
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog(IdUtils.getId(),"活着","张三",new Date(),100);
        Blog blog1 = new Blog(IdUtils.getId(),"java","张三",new Date(),99);
        Blog blog2 = new Blog(IdUtils.getId(),"mybatis","张三",new Date(),99);
        Blog blog3 = new Blog(IdUtils.getId(),"jdbc","张三",new Date(),99);
        mapper.insertBlog(blog);//XML方式
        mapper.insertBlog(blog1);
        mapper.insertBlog(blog2);
        mapper.insertBlog(blog3);
        /*mapper.insertBlog2(blog);//注解方式*/

        sqlSession.commit();
    }

    @Test//IF语句
    public void Test03() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession("SqlMapConfig.xml");
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

/*        //不传值就默认查询全部
        Map<String,String> hashmap = new HashMap();
        List<Blog> blogs = mapper.findBlogIF(hashmap);
        for(Blog blog:blogs){
            System.out.println(blog);
        }*/

        //传作者进去,或者传书名进去,或者两个一起都可以
        Map<String,String> hashmap = new HashMap();
        hashmap.put("author","张三");
        List<Blog> blogs = mapper.findBlogIF(hashmap);
        for(Blog blog:blogs){
            System.out.println(blog);
        }
    }

    @Test//Choose语句
    public void Test04() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession("SqlMapConfig.xml");
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map hashmap = new HashMap();
        hashmap.put("title","活着");
        hashmap.put("views",99);
        List<Blog> blogs = mapper.findBlogChoose(hashmap);
        for(Blog blog:blogs){
            System.out.println(blog);
        }
    }

    @Test//UPDATE-SET语句
    public void Test05() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession("SqlMapConfig.xml");
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map hashmap = new HashMap();
        hashmap.put("title","活着");
        hashmap.put("id","438f608983b145d1bc7789025bb617c9");
        int i = mapper.updateBlog(hashmap);

        sqlSession.commit();
        sqlSession.close();
    }

}

