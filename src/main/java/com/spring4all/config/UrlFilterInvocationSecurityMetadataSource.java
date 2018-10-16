package com.spring4all.config;

import com.spring4all.domain.po.MenuEntity;
import com.spring4all.domain.po.RoleEntity;
import com.spring4all.domain.po.RoleMenuEntity;
import com.spring4all.service.impl.MenuService;
import com.spring4all.service.impl.RoleMenuService;
import com.spring4all.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private RoleService roleService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取url
        //String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //FilterInvocation filterInvocation = (FilterInvocation) o;
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        if ("/login".equals(requestUrl)) {
            return null;
        }
        //查询所有角色
        List<MenuEntity> allMenu = menuService.getAllMenu();
        List<String> roles = new ArrayList<>();
        for (MenuEntity menu : allMenu) {
            Long menuId = menu.getId();
            List<RoleMenuEntity> roleMenuEntities = roleMenuService.selectByMenuId(menuId);
            for (RoleMenuEntity roleMenuEntity : roleMenuEntities) {
                Long roleId = roleMenuEntity.getRoleId();
                String role = roleService.getByRoleId(roleId);
                roles.add(role);
            }
            int size = roles.size();
            String[] values = new String[size];
            if (antPathMatcher.match(menu.getUrl(), requestUrl) && size > 0) {
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i);
                }
                //放入角色
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<>();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
