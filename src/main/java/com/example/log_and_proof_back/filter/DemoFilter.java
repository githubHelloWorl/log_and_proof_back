package com.example.log_and_proof_back.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/aaa/*") // 拦截所有的路径
public class DemoFilter implements Filter {
    // 启动服务器时 初始化方法 只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 方法调用了");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // 服务器停止时 销毁方法 只调用一次
    @Override
    public void destroy() {
        System.out.println("destory 方法销毁了");
        Filter.super.destroy();
    }
}
