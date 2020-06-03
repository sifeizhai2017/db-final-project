package com.shnu.work.controller;

import com.google.gson.Gson;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.service.IUserInformationService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserInformationService userInformationService;

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final Gson gson = new Gson();

    @RequestMapping("/getUserInfo")
    public ModelAndView getUserInfo(ModelAndView modelAndView, HttpSession session) {
        String loginUser = (String) session.getAttribute("login_user");
        if (!StringUtils.isBlank(loginUser)) {
            UserInformationEntity userInfo = userInformationService.getUserInformationEntityByUserAccount(loginUser);
            LOGGER.info("userInfo:{}", gson.toJson(userInfo));
            modelAndView.addObject("userInfo", userInfo);
        }
        modelAndView.setViewName("/userinfo");
        return modelAndView;
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(@Param("userName") String userName,
                                 @Param("userAccount") String userAccount,
                                 @Param("userSex") Integer userSex,
                                 @Param("userSignature") String userSignature) {
        UserInformationEntity resultEntity = userInformationService.getUserInformationEntityByUserAccount(userAccount);
        LOGGER.info("resultEntity:{}", gson.toJson(resultEntity));
        resultEntity.setUserName(userName);
        resultEntity.setUserSex(userSex);
        if (!StringUtils.isBlank(userSignature)) {
            resultEntity.setUserSignature(userSignature);
        }
        userInformationService.saveUser(resultEntity);

        return "redirect:/user/getUserInfo";
    }

    @RequestMapping("/backToHomepage")
    public String backToHomepage() {
        return "/index";
    }
}
