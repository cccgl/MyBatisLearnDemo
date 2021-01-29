package com.lei.dao;

import com.lei.pojo.Blog;
import com.lei.dao.BlogMapper;
import com.lei.utils.*;
import com.lei.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLData;
import java.util.*;

public class BlogMapperTest extends TestCase {
    @Test
    public void testInsert() {


        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();

        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryIf()
    {
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
        Map<String,String> map=new HashMap<>();
        map.put("title","Mybatis");
        //List<Blog> list=blogMapper.queryIf(map);
        List<Blog> list=blogMapper.queryChoose(map);
        for (Blog blog : list) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testForech()
    {
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
        Map map=new HashMap();
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(2);
        map.put("list",list);
        List<Blog> blog=blogMapper.queryForeach(map);
        for (Blog blog1 : blog) {
            System.out.println(blog1);
        }
        sqlSession.close();
    }
}