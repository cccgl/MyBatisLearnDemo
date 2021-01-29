package com.lei.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 老师类
 * @Author: cckong
 * @Date: 2021/1/26
 */
@Data
public class Teacher implements Serializable {
    private int id;
    private String name;
}
