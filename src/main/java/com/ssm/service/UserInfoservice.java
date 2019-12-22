package com.ssm.service;

import com.ssm.common.BackMsg;
import com.ssm.domain.UserInfo;

import java.util.List;

public interface UserInfoservice {
    Boolean getUserName(String username);

    BackMsg register(UserInfo userInfo);

    UserInfo login(String name, String pass);

    List<UserInfo> getStatus();
}
