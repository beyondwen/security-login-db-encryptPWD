package com.spring4all.service.impl;

import com.spring4all.domain.po.MenuEntity;
import com.spring4all.domain.MenuMapper;
import com.spring4all.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MenuService implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public boolean insert(MenuEntity menuEntity) {
        menuMapper.insert(menuEntity);
        return true;
    }

    @Override
    public MenuEntity selectByMenuname(String menuName) {
        return menuMapper.selectByMenuname(menuName);
    }

    @Override
    public List<MenuEntity> getAllMenu() {
        return menuMapper.getAllMenu();
    }
}
