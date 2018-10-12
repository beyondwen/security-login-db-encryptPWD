package com.spring4all.domain.po;

public class RoleMenuEntity {

    private Long roleMenuId;

    private Long roleId;
    
    private Long menuId;

    public Long getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(Long roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
