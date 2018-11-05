package com.itheima.dao;

import com.itheima.domain.Course;

import java.util.List;

public interface CourseDao {
    /**
     * 查询所有课程，同时把该课程下所有的选课学生查出
     * @return
     */
    List<Course> findAll();

    List<Course> findByTno(String tName);

    Course findById(int id);
}
