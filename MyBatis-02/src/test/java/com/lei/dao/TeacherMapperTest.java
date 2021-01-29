package com.lei.dao;

import com.lei.pojo.Teacher;
import com.lei.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherMapperTest extends TestCase {
    @Test
    public void testgetTeacherById()
    {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }


}