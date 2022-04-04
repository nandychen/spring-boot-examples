package com.neo.exception;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Object exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletPath();
        System.out.println("请求接口path=" + path + "发生异常......");
        if (e instanceof RuntimeException) {
            BizException be = (BizException) e;
            return new HashMap<String, Object>() {
                {
                    put("code", be.getCode());
                    put("message", be.getMessage());
                }
            };
        }

        return new HashMap<String, Object>() {
            {
                put("code", 500);
                put("message", "系统异常");
            }
        };
    }

}
