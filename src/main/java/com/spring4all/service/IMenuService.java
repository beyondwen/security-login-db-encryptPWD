package com.spring4all.service;

import com.spring4all.entity.MenuEntity;

public interface IMenuService {

    /**
     * 添加菜单
     */
    boolean insert(MenuEntity menuEntity);

    /**
     * 查询菜单
     *
     * @param menuName 菜单名
     * @return MenuEntity
     */
    MenuEntity getByMenuName(String menuName);

}
