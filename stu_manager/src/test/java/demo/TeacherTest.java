package demo;

import com.itheima.dao.TeacherDao;
import com.itheima.domain.Course;
import com.itheima.domain.Student;
import com.itheima.domain.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.InputStream;
import java.util.List;

public class TeacherTest {
    private InputStream is;
    private SqlSession session;
    private TeacherDao dao;

    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlConfig.xml");
        session = new SqlSessionFactoryBuilder().build(is).openSession();
        is.close();
        dao = session.getMapper(TeacherDao.class);
    }

    @After
    public void destroy(){
        session.commit();
        session.close();
    }

    @Test
    public void testFindAll(){
        List<Teacher> Teachers = dao.findAll();
        System.out.println(Teachers.size());



        for (Teacher s: Teachers){
            System.out.println("----------每一位老师------------");
            System.out.println(s);
            System.out.println(s.getCourses().size());
            System.out.println("教师：" + s.getTname());
            System.out.println("老师课程数量：" + s.getCourses().size());
            for (Course course : s.getCourses()) {
                System.out.println("课程：" + course.getCname());
            }
        }
    }
}
