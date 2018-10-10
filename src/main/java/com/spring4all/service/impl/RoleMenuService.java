package com.spring4all.service.impl;

import com.spring4all.entity.RoleMenuEntity;
import com.spring4all.mapper.RoleMenuMapper;
import com.spring4all.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RoleMenuService implements IRoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public boolean insert(RoleMenuEntity roleMenuEntity) {
        return false;
    }

    @Override
    public List<RoleMenuEntity> getByRoleId(Long roleId) {
        return null;
    }
}
