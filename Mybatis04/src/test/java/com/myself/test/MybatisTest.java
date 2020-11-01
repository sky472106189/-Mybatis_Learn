package com.myself.test;

import com.myself.Dao.IUserDao;
import com.myself.MybatisUtils;
import com.myself.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
    更改了封装类User.class里的变量名,birthday改成了bir
    于是查找的内容为null.
    这是因为把select * from USER WHERE id = #{ID}看成了select id,username,username,brd,sex,address from USER WHERE id = #{ID}
    很显然brd是不存在的于是为null

    解决方法:方法1.把*改成正确的全部表列名
            方法2.使用映射结果集.
                  在接口配置文件IUserDao.xml 添加<resultMap>,具体去看接口的映射xml文件
*/
public class MybatisTest {

    static Logger logger = Logger.getLogger(MybatisTest.class);

    @Test //条件查询
    public void findOne() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);

        User user = userDao.findUserById(42); //User{id=42, username='小二', brd=null, sex='男', address='火星区'}
        System.out.println(user);
        session.close();
        is.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

 /*     [com.myself.test.MybatisTest]-info:进入了testLog4j
        [com.myself.test.MybatisTest]-debug:进入了testLog4j
        [com.myself.test.MybatisTest]-error:进入了testLog4j
        */
    }

    @Test//分页查询
    public void getUserByLimit() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");
        IUserDao userDao = session.getMapper(IUserDao.class);

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = userDao.getUserByLimit(map);

        for(User user : userList){
            System.out.println(user);
        }

        session.close();
    }

    @Test//分页查询2
    public void getUserByRowBounds() throws IOException {
        SqlSession session = MybatisUtils.getSession("SqlMapConfig.xml");

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过java代码层面实现分页
        List<User> userlist = session.selectList("com.myself.Dao.IUserDao.getUserByRowBounds",null,rowBounds);

        for (User user:userlist){
            System.out.println(user);
        }
        session.close();
    }
}
