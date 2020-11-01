package com.myself.test;

import com.myself.Dao.IUserDao;
import com.myself.MybatisUtils;
import com.myself.domain.User;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


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
}
