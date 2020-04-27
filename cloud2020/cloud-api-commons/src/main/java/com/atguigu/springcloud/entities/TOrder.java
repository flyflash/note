package com.atguigu.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2020-04-17 15:58:11
 */

@Data
public class TOrder implements Serializable {
    private static final long serialVersionUID = 655601790110878355L;
    
    private Integer id;
    
    private String orderNo;
    
    private String userId;
    
    private String commodityCode;
    
    private Integer count;
    
    private Double amount;

}