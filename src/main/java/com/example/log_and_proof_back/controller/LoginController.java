package com.example.log_and_proof_back.controller;

import com.example.log_and_proof_back.pojo.Result;
import com.example.log_and_proof_back.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.log_and_proof_back.utils.JwtUtils;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @PostMapping("/login")
    public Result login(@RequestBody Student student) {
        log.info("学生登录: {}",student);

        if(student.getSpass().equals("1234")){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",2024001);
            claims.put("name","张三");
            claims.put("sex","男");
            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
            return Result.success(1,"success",jwt);
        }



        return Result.success();
    }
}

