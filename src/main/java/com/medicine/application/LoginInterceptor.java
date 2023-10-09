package com.medicine.application;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在请求处理之前执行，进行登录验证逻辑
        // 获取用户登录信息，这里假设登录信息存储在 session 中
        Object user = request.getSession().getAttribute("user");

        if (user == null) {
            // 用户未登录，可以重定向到登录页面或返回未登录错误信息
            response.sendRedirect("/login");
            return false; // 中断请求
        }

        // 用户已登录，继续执行后续操作
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 请求处理之后调用，但在视图被渲染之前
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 在整个请求处理完毕之后，通常用于清理资源等操作
    }
}
