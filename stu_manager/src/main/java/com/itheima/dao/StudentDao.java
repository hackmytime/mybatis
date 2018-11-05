package com.itheima.dao;

import com.itheima.domain.Course;
import com.itheima.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    /**
     * 查询所有学生，同时查询学生所选课程信息
     * @return
     */
    @Select("select * from tb_student")
    @Results({
            @Result(id = true,column = "sno", property = "sno"),
            @Result(column = "sname", property = "sname"),
            @Result(column = "ssex", property = "ssex"),
            @Result(property = "courses", column = "course", javaType = Course.class, many =
            @Many(select = "SELECT * FROM tb_sc sc \n" +
                    "JOIN tb_course c ON sc.Cno=c.Cno AND sc.Sno=#{sno}"))
    })
    List<Student> findAll();

    /**
     * 添加学生
     * @param s
     */
    @Insert("INSERT INTO tb_student(Sname,Spasswd,Ssex,Syear,Spro) \n" +
            "VALUES(#{sname},#{spasswd},#{ssex},#{syear},#{spro})")
    void add(Student s);

    /**
     * 修改学生
     * @param s
     */
    @Insert("update tb_student set sname=#{sname},spasswd=#{spasswd},ssex=#{ssex}," +
            "syear=#{syear},spro=#{spro} where sno=#{sno}")
    void update(Student s);

    /**
     * 删除学生
     * @param sno
     */
    @Delete("delete from tb_student where sno=#{sno}")
    void delete(int sno);
}
