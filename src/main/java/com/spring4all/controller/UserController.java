package com.spring4all.controller;

import com.spring4all.entity.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        List<UserEntity> list = new ArrayList<>();
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("first");
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUsername("two");
        list.add(userEntity);
        list.add(userEntity1);
        model.addAttribute("username", principal.getName());
        model.addAttribute("list", list);
        return "user/user";
    }

    @GetMapping("/test")
    public String test(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "user/test1";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String test1(@AuthenticationPrincipal Principal principal, Model model) {
        return "{\"project\":\"just a test\"}";
    }

}
