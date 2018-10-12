package com.spring4all.service;

import com.spring4all.domain.po.RoleEntity;

public interface IRoleService {

    /**
     * 添加角色
     */
    boolean insert(RoleEntity roleEntity);

    /**
     * 查询角色
     *
     * @param roleName 角色名
     * @return RoleEntity
     */
    RoleEntity getByRoleName(String roleName);

    /**
     * 查询角色
     *
     * @param roleId 角色名
     * @return string
     */
    String getByRoleId(Long roleId);

}
