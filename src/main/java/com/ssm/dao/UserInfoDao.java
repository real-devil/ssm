package com.ssm.dao;

import com.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {
    String getUserName(String username);

    void register(UserInfo userInfo);

    UserInfo login(@Param("name") String name, @Param("pass")String pass);

    List<UserInfo> getStatus();
}
