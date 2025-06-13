package edu.fdzc.dormmain.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {
        if ("admin".equals(username) && "123456".equals(password)) {
            return "登录成功";
        } else {
            return "用户名或密码错误";
        }
    }
}
