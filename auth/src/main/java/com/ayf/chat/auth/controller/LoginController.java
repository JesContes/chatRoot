package com.ayf.chat.auth.controller;

import com.ayf.chat.common.ApiException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YifeiAn
 * @date 2021-05-25 15:18
 */
@RestController
public class LoginController {
    @PostMapping("/login")
    public String login () throws Exception {
        return "登录成功";
    }
}
