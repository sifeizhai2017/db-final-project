package com.shnu.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tonghao
 */
@Controller
public class WelcomeController {
    /**
     * 测试视图解析器
     */
    @RequestMapping("/")
    public String welcome() {
        return "/index";
    }
}
