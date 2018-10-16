package com.spring4all.domain;

import com.spring4all.domain.po.RoleMenuEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface RoleMenuMapper {

    @Insert("insert into role_menu(role_menu_id, role_id , menu_id) values(#{roleMenuId}, #{roleId} , #{menuId})")
    int insert(RoleMenuEntity roleMenuEntity);

    @Select("select * from role_menu where role_id = #{roleId}")
    List<RoleMenuEntity> selectByRoleId(@Param("roleId") Long roleId);

    @Select("select * from role_menu where role_id = #{menuId}")
    List<RoleMenuEntity> selectByMenuId(@Param("menuId") Long menuId);
}
