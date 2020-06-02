package com.shnu.work.controller;

import com.google.gson.Gson;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.service.IUserInformationService;
import com.shnu.work.util.RedisUtils;
import com.spoon.pass.encrypt.EncryptDecrypt;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author tonghao
 */
@Controller
public class LoginController {
    @Autowired
    IUserInformationService userInformationService;

    @Autowired
    RedisUtils redisUtils;

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
    public ModelAndView saveNewUser(ModelAndView modelAndView, UserInformationEntity userInformationEntity) {
//        Date now = new Date();
        LOGGER.info("user:{}", gson.toJson(userInformationEntity));
//        userInformationEntity.setCreateTime(now);
//        userInformationEntity.setUpdateTime(now);
        // 密码加密
        userInformationEntity.setUserPassword(EncryptDecrypt.encrypt(userInformationEntity.getUserPassword(), ENCRYPT_KEY));
        UserInformationEntity returnEntity = userInformationService.saveNewUser(userInformationEntity);
        if (returnEntity != null) {
            modelAndView.addObject("msg", "success");
            modelAndView.setViewName("/login");
        } else {
            modelAndView.addObject("msg", "err");
            modelAndView.setViewName("/register");
        }

        return modelAndView;
    }

    /**
     * 管理员登陆
     *
     * @param modelAndView ModelAndView
     * @return 管理后台界面
     */
    @RequestMapping(value = "/adminLogin")
    public ModelAndView adminLogin(ModelAndView modelAndView) {
        // 暂时不对账号密码进行验证
        modelAndView.setViewName("/admin");

        return modelAndView;
    }

    /**
     * 用户登陆
     *
     * @param modelAndView ModelAndView
     * @return 主界面
     */
    @RequestMapping(value = "/userLogin")
    public ModelAndView userLogin(HttpSession session, ModelAndView modelAndView, @Param("userAccount") String userAccount, @Param("userPassword") String userPassword) {
        try {
            UserInformationEntity userAccountEntity = userInformationService.getUserInformationEntityByUserAccount(userAccount);
            LOGGER.info("userAccountEntity:{}", gson.toJson(userAccountEntity));
            String decryptPassword = EncryptDecrypt.decrypt(userAccountEntity.getUserPassword(), ENCRYPT_KEY);
            if (!userPassword.equals(decryptPassword)) {
                modelAndView.addObject("msg", "error");
                modelAndView.setViewName("/login");
            } else {
                modelAndView.addObject("msg", "success");
                modelAndView.setViewName("/index");
                //todo: 同时在session和redis中放入用户信息。参考：https://www.cnblogs.com/leeego-123/p/10476855.html
                session.setAttribute("login_user", userAccount);
                redisUtils.set("login_user", gson.toJson(userAccountEntity));
            }
        } catch (Exception e) {
            LOGGER.error("登录出错，userAccount:{}，userPassword:{}", userAccount, userPassword);
            modelAndView.addObject("msg", "error");
            modelAndView.setViewName("/login");
        }

        return modelAndView;
    }
}
