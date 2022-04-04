package com.neo.interceptor;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
            Object o, Exception e) {
        System.out.println("[error]出错了，请查看日志");
        e.printStackTrace();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 500);
        resultMap.put("message", "failure");
        if (e instanceof RuntimeException) {
            return new ModelAndView("runtime-exception", resultMap);
        }
        return new ModelAndView("exception", resultMap);
    }

}
