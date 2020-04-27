package com.atguigu.springcloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author zbh
 * @Date 2020-04-06
 * <p>Description:</p>
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;

    private String serial;
}
