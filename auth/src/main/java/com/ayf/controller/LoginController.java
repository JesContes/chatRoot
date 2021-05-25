package com.ayf.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YifeiAn
 * @date 2021-05-25 15:18
 */
@RestController
public class LoginController {
    @PostMapping("/login")
    public String login(){
        return "登录成功";
    }
}
