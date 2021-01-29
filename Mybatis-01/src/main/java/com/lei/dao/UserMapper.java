package com.lei.dao;

import com.lei.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Description: 操作数据库
 * @Author: cckong
 * @Date: 2021/1/23
 */

    public interface UserMapper {
        //获取全部用户信息
        List<User> getUserList();

        //根据用户ID获取指定用户信息
        User getUserById(int id);

        //插入一个新用户
        void addUser(User user);

        //用map插入一个新用户
        void addUserMap(Map<String,Object> map);

        //更新用户数据
        void updateUser(User user);

        //删除一个用户
        void deleteUser(int id);

        //分页获得用户列表
        List<User> getUserListPage(Map<String,Integer> map);



}
