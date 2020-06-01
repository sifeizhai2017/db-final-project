package com.shnu.work.controller;

import com.google.gson.Gson;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.service.IUserInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @return
     * @RequestParam model
     */
    @RequestMapping("/saveNewUser")
    public String saveNewUser(Model model, @RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam("userAccount") String userAccount,
                              @RequestParam("userSex") String userSex, @RequestParam("userSignature") String userSignature, @RequestParam("userNumOfDevice") String userNumOfDevice) {
        Map<String, Object> msgMap = new HashMap<>();
        UserInformationEntity user = new UserInformationEntity();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserPassword(userAccount);
        user.setUserSex((byte) ("男".equals(userSex) ? 1 : 0));
        user.setUserSignature(userSignature);
//        user.setUserNumOfDevice(Short.parseShort(userNumOfDevice));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        LOGGER.info("saveNewUser:{}", gson.toJson(user));
        UserInformationEntity returnEntity = userInformationService.saveNewUser(user);
        msgMap.put("msg", returnEntity == null ? "注册失败" : "注册成功");
        model.addAttribute("msgMap", msgMap);

        return "/login";
    }
}
