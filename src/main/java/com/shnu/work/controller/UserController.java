package com.shnu.work.controller;

import com.google.gson.Gson;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.service.IUserInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 和用户相关的Controller
 *
 * @author Shinomiya Kaguya
 */
@Controller
public class UserController {
    @Autowired
    IUserInformationService userInformationService;

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final Gson gson = new Gson();

    @RequestMapping("/getUserInfo")
    public ModelAndView getUserInfo(ModelAndView modelAndView, HttpSession session) {
        String loginUser = (String) session.getAttribute("login_user");
        UserInformationEntity userInfo = userInformationService.getUserInformationEntityByUserAccount("woshinidie");

        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("/userinfo");
        return modelAndView;
    }

    @RequestMapping("/backToHomepage")
    public String backToHomepage() {
        return "/index";
    }
}
