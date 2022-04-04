package com.neo.web;

import com.neo.exception.BizException;
import com.neo.exception.ErrorCode;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/test/hello")
    public String hello(Locale locale, Model model) {
        long x = System.currentTimeMillis();
        System.out.println("time=" + x);
        if (x % 2 == 0) {
            throw new BizException(ErrorCode.FAILURE);
        }
        return "Hello World";
    }

}