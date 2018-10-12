package com.spring4all.domain;

import com.spring4all.domain.po.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MenuMapper {

    int insert(MenuEntity menuEntity);

    MenuEntity selectByMenuname(@Param("menuName") String menuName);

    List<MenuEntity> getAllMenu();

}
