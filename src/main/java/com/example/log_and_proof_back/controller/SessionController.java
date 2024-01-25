package com.example.log_and_proof_back.controller;

import com.example.log_and_proof_back.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
    //设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("login_username","myname"));
        return Result.success(1,"success", new String[]{"aaa", "bbb"});
    }

    // 获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        //获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login_username")){
                //输出name 为 login_username 的cookie
                System.out.println("login_username:"+cookie.getValue());
            }
        }
        return Result.success(1,"success", new String[]{"aaa", "bbb"});
    }
}