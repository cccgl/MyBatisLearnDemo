package com.lei.pojo;

import lombok.Data;

/**
 * @Description: 学生类 用来描述一对多 多对一关系
 * @Author: cckong
 * @Date: 2021/1/26
 */
@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}
