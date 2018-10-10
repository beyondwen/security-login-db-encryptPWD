package com.spring4all.service;

import com.spring4all.entity.RoleMenuEntity;
import com.spring4all.entity.UserRoleEntity;

import java.util.List;

public interface IRoleMenuService {

    /**
     * 添加角色菜单关联
     */
    boolean insert(RoleMenuEntity roleMenuEntity);

    /**
     * 根据角色id查询菜单
     *
     * @param roleId 角色id
     * @return RoleEntity
     */
    List<RoleMenuEntity> getByRoleId(Long roleId);

}
