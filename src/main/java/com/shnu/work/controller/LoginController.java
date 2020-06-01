package com.shnu.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tonghao
 */
@Controller
public class LoginController {
    /**
     * 通用的登录操作
     */
    @RequestMapping("/")
    public String commonLogin() {
        return "/login";
    }
}
