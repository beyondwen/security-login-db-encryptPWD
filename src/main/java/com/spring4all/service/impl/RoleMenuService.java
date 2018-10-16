package com.spring4all.service.impl;

import com.spring4all.domain.RoleMenuMapper;
import com.spring4all.domain.po.RoleMenuEntity;
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
    public List<RoleMenuEntity> selectByRoleId(Long roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }

    @Override
    public List<RoleMenuEntity> selectByMenuId(Long menuId) {
        return roleMenuMapper.selectByMenuId(menuId);
    }
}
