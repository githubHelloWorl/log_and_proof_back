package com.example.log_and_proof_back.exception;

import com.example.log_and_proof_back.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 捕获全局的异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        ex.printStackTrace();

        return Result.error(0,"这一步操作失败,请联系管理员",null);
    }
}
