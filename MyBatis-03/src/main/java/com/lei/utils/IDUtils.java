package com.lei.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @Description: 生成随机数ID
 * @Author: cckong
 * @Date: 2021/1/28
 */
public class IDUtils {
    public static String getID()
    {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void testgetID()
    {
        System.out.println(getID());
        System.out.println(getID());
    }

}
