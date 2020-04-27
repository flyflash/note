package com.example.baseapi.pojo;

import java.io.Serializable;

/**
 * @Author zbh
 * @Date 2020-03-27
 * <p>Description:</p>
 */
public class UserInfoVO implements Serializable {

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

    /**
     * 地址
     */
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
