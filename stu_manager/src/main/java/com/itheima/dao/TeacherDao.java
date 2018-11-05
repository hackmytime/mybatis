package com.itheima.dao;

import com.itheima.domain.Teacher;

import java.util.List;

public interface TeacherDao {
    /**
     * 查询所有老师，同时查出老师全部课程
     * @return
     */
    List<Teacher> findAll();
}
