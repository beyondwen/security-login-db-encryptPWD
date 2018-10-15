package com.spring4all.service;

import com.spring4all.domain.po.MenuEntity;

import java.util.List;

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
    MenuEntity selectByMenuname(String menuName);


    List<MenuEntity> getAllMenu();
}
