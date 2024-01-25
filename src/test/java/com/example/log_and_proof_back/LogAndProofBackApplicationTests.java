package com.example.log_and_proof_back;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

@SpringBootTest
class LogAndProofBackApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void test1(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"chenyi") //签名算法
                .setClaims(claims) // 自定义内容
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000)) // 设置有效日期
                .compact(); //返回字符串类型的返回值
        System.out.println(jwt);
    }

    @Test
    public void test2(){
        Claims claims = Jwts.parser()
                .setSigningKey("chenyi") //指定签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwNjE1MTQxNX0.a7jWaTOifRl_M6zpVef7bjpxOAloBSlVKH480vFTX98")//解析令牌
                .getBody(); //得到主体
        System.out.println(claims);
    }
}
