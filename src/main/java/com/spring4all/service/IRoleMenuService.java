package com.spring4all.service;

import com.spring4all.domain.po.RoleMenuEntity;
import com.spring4all.domain.po.UserRoleEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    List<RoleMenuEntity> selectByRoleId(Long roleId);


    List<RoleMenuEntity> selectByMenuId(Long menuId);

}
