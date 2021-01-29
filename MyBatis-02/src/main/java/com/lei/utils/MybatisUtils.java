package com.lei.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: sqlSessionFactoryBuilder——>sqlSessionFactory-->sqlSession
 * //每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。
 *  SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
 *  而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先配置的 Configuration 实例来构建出 SqlSessionFactory 实例。
 * @Author: cckong
 * @Date: 2021/1/23
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //根据创建好的SqlSessionFactory，创建一个sqlsession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
