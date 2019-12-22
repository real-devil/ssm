package com.ssm.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    List<String> getPosition();
}
