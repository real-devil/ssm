package com.ssm.service.impl;

import com.ssm.common.BackMsg;
import com.ssm.dao.UserInfoDao;
import com.ssm.domain.UserInfo;
import com.ssm.service.UserInfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoserviceImpl implements UserInfoservice {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public Boolean getUserName(String username) {

        String name=userInfoDao.getUserName(username);
        if (name!=null){
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public BackMsg register(UserInfo userInfo) {
        BackMsg backMsg = new BackMsg();
//        Boolean aBoolean = getUserName(userInfo.getUsername());
        try {
            userInfoDao.register(userInfo);
            backMsg.setStatus(1);
        } catch (Exception e) {
            backMsg.setStatus(0);
            backMsg.setMsg(e.getMessage());
        }
        return backMsg;
    }

    @Override
    public UserInfo login(String name, String pass) {
        return userInfoDao.login(name,pass);
    }

    @Override
    public List<UserInfo> getStatus() {
        return userInfoDao.getStatus();
    }
}
