package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.CommonResult;
import com.atguigu.springcloud.entities.TAccount;
import com.atguigu.springcloud.service.TAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * (TAccount)表控制层
 *
 * @author makejava
 * @since 2020-04-17 16:23:12
 */
@Slf4j
@RestController
@RequestMapping("account")
public class TAccountController {
    /**
     * 服务对象
     */
    @Resource
    private TAccountService tAccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param uid 用户id
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public CommonResult<TAccount> selectOne(String uid) {
        return new CommonResult<>(200, "成功", this.tAccountService.queryById(uid));
    }

    @GetMapping("/decr")
    public CommonResult<TAccount> decr(@RequestParam("userId") String uid,
                                       @RequestParam("amount") double amount){

        log.info("account---------------------------->userId:{}, amount:{}", uid, amount);

       /* try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        TAccount tAccount = tAccountService.update(uid, amount);
        return new CommonResult<>(200, "成功", tAccount);
    }

}