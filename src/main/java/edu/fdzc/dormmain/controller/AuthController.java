package edu.fdzc.dormmain.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 登录
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        if ("admin".equals(request.getUsername()) && "123456".equals(request.getPassword())) {
            return "登录成功";
        } else {
            return "用户名或密码错误";
        }
    }

    // 添加静态内部类接收 JSON
    public static class LoginRequest {
        private String username;
        private String password;
        // 必须提供 getter/setter
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
