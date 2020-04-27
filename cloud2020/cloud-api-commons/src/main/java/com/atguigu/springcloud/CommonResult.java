package com.atguigu.springcloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zbh
 * @Date 2020-04-06
 * <p>Description:</p>
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
