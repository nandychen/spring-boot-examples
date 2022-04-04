package com.neo.interceptor;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String path = request.getServletPath();
        if (System.currentTimeMillis() % 2 != 0) {
            throw new IllegalArgumentException("access denied...");
        }
        System.out.println("path=" + path);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //return 之前
        int status = response.getStatus();
        System.out.println("status=" + status);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //return 之后
        if (Objects.nonNull(ex)) {
            System.out.println("ex=" + ex.getMessage());
        } else {
            System.out.println("status=" + response.getStatus());
        }
    }
}
