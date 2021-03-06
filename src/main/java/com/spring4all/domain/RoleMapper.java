package com.spring4all.domain;

import com.spring4all.domain.po.RoleEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface RoleMapper {

    @Insert("insert into role(role_id, role_name) values(#{id}, #{rolename})")
    int insert(RoleEntity roleEntity);

    @Select("select * from role where role_name = #{roleName}")
    RoleEntity selectByRolename(@Param("roleName") String roleName);

    @Select("select role_name roleName from role where role_id = #{roleid}")
    String selectByRoleid(@Param("roleid") Long roleid);
}
