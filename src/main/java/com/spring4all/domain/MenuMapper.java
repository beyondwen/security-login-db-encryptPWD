package com.spring4all.domain;

import com.spring4all.domain.po.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface MenuMapper {

    int insert(MenuEntity menuEntity);

    MenuEntity selectByMenuname(@Param("menuName") String menuName);

    List<MenuEntity> getAllMenu();

}
