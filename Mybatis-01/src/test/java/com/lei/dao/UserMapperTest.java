package com.lei.dao;

import com.lei.pojo.User;
import com.lei.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest extends TestCase {

    static Logger logger=Logger.getLogger(UserMapperTest.class);
    //获取所有用户测试
    @Test
    public void testgetUserList(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

        //关闭SqlSession
        sqlSession.close();
    }

    //指定id获取用户测试
    @Test
    public void testgetUserById()
    {
        SqlSession sqlSession=MybatisUtils.getSqlSession();//获取SqlSession对象

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.getUserById(1);
        System.out.println(user);


        sqlSession.close();

    }

    //插入一个新的用户
    @Test
    public void testaddUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(new User(4,"cc","123445"));

        sqlSession.commit();
        sqlSession.close();


    }

    //更新一个用户的数据
    @Test
    public void testupdateUser()
    {
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(4,"cgl","123123"));

        sqlSession.commit();
        sqlSession.close();
    }


    //删除一个用户
    @Test
    public void testdeleteUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(3);

        sqlSession.commit();
        sqlSession.close();
    }

    //以map的形式添加一个用户
    @Test
    public void testaddUserMap(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        Map<String,Object> map=new HashMap<>();
        map.put("mapId",6);
        map.put("mapName","ccmap");
        map.put("mapPwd","123123");
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.addUserMap(map);


        sqlSession.commit();
        User user=userMapper.getUserById(4);
        System.out.println(user);
        sqlSession.close();
    }

    //分页获得用户列表
    @Test
    public void testgetUserListPage()
    {
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        Map<String,Integer> map=new HashMap<>();
        map.put("startPage",1);
        map.put("pageSize",2);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> list=userMapper.getUserListPage(map);
        for(User tmp:list)
        {
            System.out.println(tmp);
        }
        sqlSession.close();
    }


}