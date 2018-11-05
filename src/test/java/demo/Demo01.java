package demo;


import com.zl.dao.UserDao;
import com.zl.domain.User;
import com.zl.mybatis.io.Resources;
import com.zl.mybatis.sqlsession.SqlSession;
import com.zl.mybatis.sqlsession.SqlSessionFactory;
import com.zl.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取SqlSession对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession session = sqlSessionFactory.openSession();

        // 获取代理对象
        UserDao dao = session.getMapper(UserDao.class);
        // 执行sql
        List<User> list = dao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        // 释放资源
        session.close();
    }
}
