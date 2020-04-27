package com.example.consumerservice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.baseapi.api.UserInfoService;
import com.example.baseapi.pojo.UserInfoDTO;
import com.example.baseapi.pojo.UserInfoVO;
import com.example.consumerservice.pojo.UserInfoParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zbh
 * @Date 2020-03-27
 * <p>Description:</p>
 */

@RestController
public class UserInfoController {

    @Reference
    private UserInfoService userInfoService;

    @RequestMapping("/getUserInfoById/{id}")
    public UserInfoVO getUserInfoById(@PathVariable("id") Long id){
        System.out.println("controller id:" + id);
        return userInfoService.getUserInfoById(id);
    }

    @RequestMapping("/getUserInfo")
    public UserInfoVO getUserInfo(UserInfoParam userInfoParam){

        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(userInfoParam.getId());
        dto.setName(userInfoParam.getName());
        dto.setAge(userInfoParam.getAge());
        return userInfoService.getUserInfo(dto);
    }
}
