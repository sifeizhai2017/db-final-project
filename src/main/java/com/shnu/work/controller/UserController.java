package com.shnu.work.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.shnu.work.dto.UserDataWhileUsingDTO;
import com.shnu.work.entity.UserDataWhileUsingEntity;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.service.IUserDataWhileUsingService;
import com.shnu.work.service.IUserInformationService;
import com.shnu.work.util.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

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

    @Autowired
    IUserDataWhileUsingService userDataWhileUsingService;

    @Autowired
    RedisUtils redisUtils;

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

    @RequestMapping("/getSensorInfo")
    public ModelAndView getSensorInfo(ModelAndView modelAndView, HttpSession session) {
        String loginUser = (String) session.getAttribute("login_user");
        if (!StringUtils.isBlank(loginUser)) {
            UserInformationEntity userInfo = userInformationService.getUserInformationEntityByUserAccount(loginUser);
            LOGGER.info("userInfo:{}", gson.toJson(userInfo));
            List<UserDataWhileUsingEntity> userDataList =
                    userDataWhileUsingService.listUserDataWhileUsingEntitiesByUserId(userInfo.getId());
            LOGGER.info("userDataList:{}", gson.toJson(userDataList));
            modelAndView.addObject("userDataList", userDataList);
        }
        modelAndView.setViewName("/sensorinfo");
        return modelAndView;
    }

    @RequestMapping("/saveNewRecord")
    public String saveNewRecord(HttpSession session, UserDataWhileUsingDTO userDataWhileUsingDto) throws ParseException {
        LOGGER.info("userDataWhileUsingDto:{}", gson.toJson(userDataWhileUsingDto));
        String loginUser = (String) session.getAttribute("login_user");
        //从redis中获取用户信息
        String loginUserJson = redisUtils.get("login_user_" + loginUser);
        UserInformationEntity loginUserEntity = gson.fromJson(loginUserJson, UserInformationEntity.class);
        LOGGER.info("loginUserEntity:{}", gson.toJson(loginUserEntity));

        UserDataWhileUsingEntity userDataWhileUsingEntity = new UserDataWhileUsingEntity();
        BeanUtils.copyProperties(userDataWhileUsingDto, userDataWhileUsingEntity);
        userDataWhileUsingEntity.setUserDocumentTime(DateUtils.parseDate(userDataWhileUsingDto.getUserDocumentTime(), "yyyy-MM-dd"));
        userDataWhileUsingEntity.setUserId(loginUserEntity.getId());
        userDataWhileUsingEntity.setUserName(loginUserEntity.getUserName());

        UserDataWhileUsingEntity save = userDataWhileUsingService.save(userDataWhileUsingEntity);
        return "/index";
    }

    @RequestMapping("/updateRecord")
    public String updateRecord(HttpSession session) {

        return null;
    }

    @RequestMapping("/removeRecord")
    public String removeRecord() {

        return null;
    }
}
