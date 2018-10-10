package com.spring4all.service.impl;

import com.spring4all.entity.RoleEntity;
import com.spring4all.mapper.RoleMapper;
import com.spring4all.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RoleService implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean insert(RoleEntity roleEntity) {
        return false;
    }

    @Override
    public RoleEntity getByRoleName(String roleName) {
        return null;
    }

    @Override
    public String getByRoleId(Long roleId) {
        String roleName = roleMapper.selectByRoleid(roleId);
        return roleName;
    }
}
