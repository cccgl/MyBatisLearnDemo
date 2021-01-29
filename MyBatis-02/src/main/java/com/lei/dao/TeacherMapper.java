package com.lei.dao;

import com.lei.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    public Teacher getTeacherById( int id);
}
