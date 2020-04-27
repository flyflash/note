package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.CommonResult;
import com.atguigu.springcloud.entities.TStorage;
import com.atguigu.springcloud.service.TStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TStorage)表控制层
 *
 * @author makejava
 * @since 2020-04-17 16:27:34
 */
@Slf4j
@RestController
@RequestMapping("storage")
public class TStorageController {
    /**
     * 服务对象
     */
    @Resource
    private TStorageService tStorageService;

    /**
     * 通过主键查询单条数据
     *
     * @param code 商品码
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommonResult<TStorage> selectOne(String code) {

        CommonResult<TStorage> result = new CommonResult<>();

        result.setCode(200);
        result.setMessage("查询成功");
        result.setData(this.tStorageService.queryById(code));

        return result;
    }

    @GetMapping("/decr")
    public CommonResult decr(@RequestParam("commodityCode") String commodityCode,
                             @RequestParam("count") int count){

        log.info("storage--------------------->code:{}, count: {}", commodityCode, count);

        tStorageService.update(commodityCode, count);

        return new CommonResult(200, "成功", null);
    }

}