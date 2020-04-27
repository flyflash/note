package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.CommonResult;
import com.atguigu.springcloud.entities.TOrder;
import com.atguigu.springcloud.service.TOrderService;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2020-04-17 15:58:23
 */

@Slf4j
@RestController
@RequestMapping("order")
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommonResult<TOrder> selectOne(Integer id) {
        return new CommonResult<>(200, "成功", this.orderService.queryById(id));
    }

    @GetMapping("/init")
    public CommonResult init(TOrder order){

        log.info("order------------------------------->oder:{}", order);

        orderService.insert(order);

        return new CommonResult<>(200, "成功", null);
    }

}