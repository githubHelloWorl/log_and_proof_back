package com.example.log_and_proof_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 由于Filter属于 javaweb 三大组件之一,并不属于spring,所以要加注解 @ServletComponentScan
@ServletComponentScan //开启了对servlet组件的支持
@SpringBootApplication
public class LogAndProofBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogAndProofBackApplication.class, args);
    }

}
