package com.spring4all.config;

import com.spring4all.entity.UserEntity;
import com.spring4all.service.IRoleService;
import com.spring4all.service.IUserRoleService;
import com.spring4all.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleService roleService;

    /*@Autowired
    AnyUserDetailsService(IUserService userService) {
        this.userService = userService;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        Long userId = userEntity.getId();
        List<Long> roleIds = userRoleService.getByUserId(userId);
        List<String> roles = new ArrayList<>();
        for (Long roleId : roleIds) {
            String roleName = roleService.getByRoleId(roleId);
            roles.add(roleName);
        }
        Object[] rolenames = roles.toArray();
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(rolenames);
        return new User(userEntity.getUsername(), userEntity.getPassword(), simpleGrantedAuthorities);
    }

    /**
     * 权限字符串转化
     * <p>
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     *
     * @param roleStr 权限字符串
     */
    private List<SimpleGrantedAuthority> createAuthorities(Object[] roleStr) {
        //String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Object role : roleStr) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority((String) role));
        }
        return simpleGrantedAuthorities;
    }

}
