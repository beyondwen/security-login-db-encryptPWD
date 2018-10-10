package com.spring4all.mapper;

import com.spring4all.entity.MenuEntity;
import com.spring4all.entity.RoleEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MenuMapper {

    @Insert("insert into menu(id, menu_name) values(#{id}, #{menuName})")
    int insert(MenuEntity menuEntity);

    @Select("select * from menu where menu_name = #{menuName}")
    MenuEntity selectByMenuname(@Param("menuName") String menuName);
}
