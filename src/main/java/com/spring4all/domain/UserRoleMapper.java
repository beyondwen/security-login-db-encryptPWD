package com.spring4all.domain;

import com.spring4all.domain.po.UserRoleEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserRoleMapper {

    @Insert("insert into user_role(user_role_id, user_id , role_id) values(#{userRoleId}, #{userId} , #{roleId})")
    int insert(UserRoleEntity userRoleEntity);

    @Select("select role_id roleId from user_role where user_id = #{userId}")
    List<Long> selectByUserId(@Param("userId") Long userId);
}
