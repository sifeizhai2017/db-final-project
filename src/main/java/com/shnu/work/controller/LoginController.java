package com.shnu.work.controller;

import com.google.gson.Gson;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.service.IUserInformationService;
import com.spoon.pass.encrypt.EncryptDecrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tonghao
 */
@Controller
public class LoginController {
    @Autowired
    IUserInformationService userInformationService;

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final Gson gson = new Gson();

    private final String ENCRYPT_KEY = "developedByTongHao";

    /**
     * 通用的登录操作
     *
     * @return 登录页面
     */
    @RequestMapping("/")
    public String commonLogin() {
        return "/login";
    }

    /**
     * 跳转用户注册页面
     *
     * @return 注册页面
     */
    @RequestMapping("/register")
    public String userRegister() {
        return "/register";
    }

    /**
     * 新增用户
     *
     * @param modelAndView          ModelAndView
     * @param userInformationEntity 要插入表的用户
     * @return 跳转地址
     */
    @PostMapping(value = "/saveNewUser")
    public String saveNewUser(ModelAndView modelAndView, UserInformationEntity userInformationEntity) {
        Date now = new Date();
        Map<String, Object> msgMap = new HashMap<>();
        LOGGER.info("user:{}", gson.toJson(userInformationEntity));
        userInformationEntity.setCreateTime(now);
        userInformationEntity.setUpdateTime(now);
        userInformationEntity.setUserPassword(EncryptDecrypt.encrypt(userInformationEntity.getUserPassword(), ENCRYPT_KEY));
        UserInformationEntity returnEntity = userInformationService.saveNewUser(userInformationEntity);
        msgMap.put("msg", returnEntity == null ? "注册失败" : "注册成功");
        modelAndView.addObject("msgMap", msgMap);

        return "/login";
    }
}
