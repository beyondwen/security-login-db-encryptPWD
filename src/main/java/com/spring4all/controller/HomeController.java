package com.spring4all.controller;

import com.spring4all.domain.po.UserEntity;
import com.spring4all.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @Autowired
    private IUserService userService;

    @GetMapping({"/", "/index", "/home"})
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/forbidden")
    public String forbidden() {
        return "forbidden";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserEntity userEntity) {
        // 此处省略校验逻辑
        if (userService.insert(userEntity))
            return "redirect:register?success";
        return "redirect:register?error";
    }

}
