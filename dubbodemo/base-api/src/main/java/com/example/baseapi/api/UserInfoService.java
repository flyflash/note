package com.example.baseapi.api;

import com.example.baseapi.pojo.UserInfoDTO;
import com.example.baseapi.pojo.UserInfoVO;

public interface UserInfoService {

    UserInfoVO getUserInfo(UserInfoDTO dto);

    UserInfoVO getUserInfoById(Long id);
}
