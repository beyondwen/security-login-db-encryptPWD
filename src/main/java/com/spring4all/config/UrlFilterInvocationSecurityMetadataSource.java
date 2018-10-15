package com.spring4all.config;

import com.spring4all.domain.po.MenuEntity;
import com.spring4all.domain.po.RoleEntity;
import com.spring4all.service.impl.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //查询所有角色
        List<MenuEntity> allMenu = menuService.getAllMenu();
        for (MenuEntity menu : allMenu) {
            List<RoleEntity> roles = menu.getRoles();
            int size = roles.size();
            String[] values = new String[size];
            for (int i = 0; i < size; i++) {
                values[i] = roles.get(i).getRoleName();
            }
            //放入角色
            return SecurityConfig.createList(values);
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
