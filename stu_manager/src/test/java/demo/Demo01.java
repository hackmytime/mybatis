package demo;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Demo01 {
    private InputStream is;
    private SqlSession session;
    private StudentDao dao;

    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlConfig.xml");
        session = new SqlSessionFactoryBuilder().build(is).openSession();
        is.close();
        dao = session.getMapper(StudentDao.class);
    }

    @After
    public void destroy(){
        session.commit();
        session.close();
    }

    @Test
    public void testFindAll(){
        List<Student> students = dao.findAll();
        for (Student s: students){
            System.out.println(s);
        }
    }

    @Test
    public void testAdd(){
        Student s  = new Student();
        s.setSname("杨杰");
        s.setSpasswd("123456");
        s.setSpro("计算机");
        s.setSsex("男");
        s.setSyear("2018");

        dao.add(s);
     }

    @Test
    public void testUpdate(){
        Student s  = new Student();
        s.setSname("杨杰01");
        s.setSpasswd("123456");
        s.setSpro("计算机");
        s.setSsex("男");
        s.setSyear("2018");
        s.setSno(14102023);
        dao.update(s);
    }

    @Test
    public void testDelete(){
        dao.delete(14102023);
    }
}
