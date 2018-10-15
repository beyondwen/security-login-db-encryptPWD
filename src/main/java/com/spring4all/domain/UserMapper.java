package com.spring4all.domain;

import com.spring4all.domain.po.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into user(username, password, nickname, roles) values(#{username}, #{password}, #{nickname}, #{roles})")
    int insert(UserEntity userEntity);

    @Select("select * from user where username = #{username}")
    UserEntity selectByUsername(@Param("username") String username);

}
