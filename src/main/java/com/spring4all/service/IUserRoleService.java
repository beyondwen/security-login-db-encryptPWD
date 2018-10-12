package com.spring4all.service;

import com.spring4all.domain.po.UserRoleEntity;

import java.util.List;

public interface IUserRoleService {

    /**
     * 添加用户角色关联
     */
    boolean insert(UserRoleEntity userRoleEntity);

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return RoleEntity
     */
    List<Long> getByUserId(Long userId);

}
