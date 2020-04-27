package com.example.consumerservice.pojo;

import java.io.Serializable;

/**
 * @Author zbh
 * @Date 2020-03-27
 * <p>Description:</p>
 */
public class UserInfoParam implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 性别
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
