package demo;

import com.itheima.dao.CourseDao;
import com.itheima.domain.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CourseTest {
    private InputStream is;
    private SqlSession session;
    private CourseDao dao;
    private SqlSessionFactory factory;

    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
        dao = session.getMapper(CourseDao.class);
        is.close();
    }

    @After
    public void destroy(){
        session.commit();
        session.close();
    }

    @Test
    public void testFindAll(){
        List<Course> Courses = dao.findAll();
        for (Course s: Courses){
            System.out.println(s);
        }
    }

    @Test
    public void testFindCourseByTname(){
        List<Course> courses = dao.findByTno("张磊");
        System.out.println(courses.size());
        System.out.println(courses.hashCode());
        session.clearCache();
//        session = factory.openSession();
//        sqlSession.getMapper();
        System.out.println("----------------------------------");
        List<Course> courses2 = dao.findByTno("张磊");
        System.out.println(courses.size());
        System.out.println(courses.hashCode());
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFindCourse(){
        Course c1 = dao.findById(201701);
        System.out.println(c1);
//        session.clearCache();
        Course c2 = dao.findById(201701);
        System.out.println(c2);


    }

    /**
     * 测试二级缓存
     * 注意：MyBatis中配置缓存时，持久层需实现序列化。
     */
    @Test
    public void testFindCourse2(){
        SqlSession session1 = factory.openSession();
        Course c1 = session1.selectOne("com.itheima.dao.CourseDao.findById",201701);
        session1.close();
        System.out.println(c1);
//        session.clearCache();
        SqlSession session2 = factory.openSession();
        Course c2 = session2.selectOne("com.itheima.dao.CourseDao.findById",201701);
        session2.close();
        System.out.println(c2);
    }
}
