package com.lei.dao;

import com.lei.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询学生名字与对应老师的名字
    public List<Student> getStuTea();

    public List<Student> StudentTeacher2();
}
