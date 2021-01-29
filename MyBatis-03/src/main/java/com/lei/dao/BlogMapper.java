package com.lei.dao;

import com.lei.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //添加博客
    void addBlog(Blog blog);

    //if动态SQL查询
    List<Blog> queryIf(Map<String,String> map);

    //choose when
    List<Blog> queryChoose(Map<String,String> map);

    //foreach
    List<Blog> queryForeach(Map map);
}
