package com.example.providerservice.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.baseapi.api.UserInfoService;
import com.example.baseapi.pojo.UserInfoDTO;
import com.example.baseapi.pojo.UserInfoVO;
import org.springframework.stereotype.Component;

/**
 * @Author zbh
 * @Date 2020-03-27
 * <p>Description:</p>
 */

@Service
@Component
public class UserInfoServiceImpl implements UserInfoService {


    @Override
    public UserInfoVO getUserInfo(UserInfoDTO dto) {
        UserInfoVO vo = new UserInfoVO();
        vo.setId(dto.getId());
        vo.setAge(dto.getAge());
        vo.setName(dto.getName());
        vo.setAddress("清华大学");

        return vo;
    }

    @Override
    public UserInfoVO getUserInfoById(Long id) {
        System.out.println("service id:" + id);
        UserInfoVO vo = new UserInfoVO();
        vo.setId(id);
        vo.setAge(20);
        vo.setName("小明");
        vo.setAddress("北京大学");

        return vo;
    }
}
