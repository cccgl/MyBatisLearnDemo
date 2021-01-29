package com.lei.dao;

import com.lei.pojo.Student;
import com.lei.pojo.Teacher;
import com.lei.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest extends TestCase {
    @Test
    public void testgetStuTea(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> stu =studentMapper.getStuTea();
        for (Student student : stu) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void testgetStuTea2()

    {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> stu =studentMapper.getStuTea();
        for (Student student : stu) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void testcacheTest()
    {
        //sqlSession1 的会话进行第一次查询。查询后一级缓存存入二级缓存后失效
        SqlSession sqlSession1=MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper=sqlSession1.getMapper(TeacherMapper.class);
        Teacher t1=teacherMapper.getTeacherById(1);
        System.out.println(t1);
        sqlSession1.close();

        //新建sqlSession2进行查询 如果在二级缓存命中则不需要连接JDBC进行查询
        System.out.println("================================");
        SqlSession sqlSession2=MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper2=sqlSession2.getMapper(TeacherMapper.class);
        Teacher t2=teacherMapper2.getTeacherById(1);
        System.out.println(t2);
        sqlSession1.close();

        //查看t1 t2是否一直
        System.out.println("=======================================");
        System.out.println(t1==t2);

    }
}