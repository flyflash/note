package com.atguigu.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * (TStorage)实体类
 *
 * @author makejava
 * @since 2020-04-17 16:27:30
 */

@Data
public class TStorage implements Serializable {
    private static final long serialVersionUID = -93433713767857707L;
    
    private Integer id;
    
    private String commodityCode;
    
    private String name;
    
    private Integer count;

}