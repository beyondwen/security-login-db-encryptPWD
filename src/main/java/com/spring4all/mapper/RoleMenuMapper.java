package com.spring4all.mapper;

import com.spring4all.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMenuMapper {

    @Insert("insert into role_menu(role_menu_id, role_id , menu_id) values(#{roleMenuId}, #{roleId} , #{menuId})")
    int insert(UserRoleEntity userRoleEntity);

    @Select("select * from role_menu where role_id = #{roleId}")
    List<UserRoleEntity> selectByRoleId(@Param("roleId") Long roleId);
}