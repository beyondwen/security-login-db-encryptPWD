package com.spring4all.service.impl;

import com.spring4all.entity.UserRoleEntity;
import com.spring4all.mapper.UserRoleMapper;
import com.spring4all.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserRoleService implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean insert(UserRoleEntity userRoleEntity) {
        //userRoleEntity.set
        return false;
    }

    /*@Override
    public List<String> getByUserId(String userId) {
        List<String> roles = userRoleMapper.selectByUserId(userId);
        return roles;
    }*/

    @Override
    public List<Long> getByUserId(Long userId) {
        List<Long> roles = userRoleMapper.selectByUserId(userId);
        return roles;
    }
}
