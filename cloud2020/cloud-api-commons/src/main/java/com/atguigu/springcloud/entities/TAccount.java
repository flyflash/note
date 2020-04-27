package com.atguigu.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * (TAccount)实体类
 *
 * @author makejava
 * @since 2020-04-17 16:23:07
 */

@Data
public class TAccount implements Serializable {
    private static final long serialVersionUID = -65916650788679390L;
    
    private Integer id;
    
    private String userId;
    
    private Double amount;

}