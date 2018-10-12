package com.spring4all.service.impl;

import com.spring4all.domain.po.MenuEntity;
import com.spring4all.domain.MenuMapper;
import com.spring4all.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MenuService implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public boolean insert(MenuEntity menuEntity) {
        return false;
    }

    @Override
    public MenuEntity getByMenuName(String menuName) {
        return null;
    }
}
