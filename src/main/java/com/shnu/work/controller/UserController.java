package com.shnu.work.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shnu.work.dto.UserDataWhileUsingDTO;
import com.shnu.work.entity.UserDataWhileUsingEntity;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.service.IUserDataWhileUsingService;
import com.shnu.work.service.IUserInformationService;
import com.shnu.work.util.NewRedisUtils;
import com.shnu.work.util.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

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
        listSensorData(modelAndView, loginUser);
        modelAndView.setViewName("/sensorinfo");
        return modelAndView;
    }

    private void listSensorData(ModelAndView modelAndView, String loginUser) {
        if (!StringUtils.isBlank(loginUser)) {
            NewRedisUtils redisUtils = NewRedisUtils.getRedisUtil();
            UserInformationEntity userInfo = userInformationService.getUserInformationEntityByUserAccount(loginUser);
            LOGGER.info("userInfo:{}", gson.toJson(userInfo));
            List<UserDataWhileUsingEntity> userDataList =
                    userDataWhileUsingService.listUserDataWhileUsingEntitiesByUserId(userInfo.getId());
            LOGGER.info("userDataList Before Redis:{}", gson.toJson(userDataList));
            Set<String> redisUserData = redisUtils.keys(2, "location_info_" + userInfo.getUserAccount() + "_*");
            redisUserData.stream().map(key -> redisUtils.get(2, key)).map(value -> gson.fromJson(value, UserDataWhileUsingEntity.class)).forEach(userDataList::add);
            LOGGER.info("userDataList After Redis:{}", gson.toJson(userDataList));
            modelAndView.addObject("userDataList", userDataList);
        }
    }

    @RequestMapping("/saveNewRecord")
    public ModelAndView saveNewRecord(ModelAndView modelAndView, HttpSession session, UserDataWhileUsingDTO userDataWhileUsingDto) throws ParseException {
        LOGGER.info("userDataWhileUsingDto:{}", gson.toJson(userDataWhileUsingDto));
        String loginUser = (String) session.getAttribute("login_user");
        NewRedisUtils redisUtils = NewRedisUtils.getRedisUtil();
        //从redis中获取用户信息
        String loginUserJson = redisUtils.get(0, session.getId());
        UserInformationEntity loginUserEntity = gson.fromJson(loginUserJson, UserInformationEntity.class);
        LOGGER.info("loginUserEntity:{}", gson.toJson(loginUserEntity));

        UserDataWhileUsingEntity userDataWhileUsingEntity = new UserDataWhileUsingEntity();
        BeanUtils.copyProperties(userDataWhileUsingDto, userDataWhileUsingEntity);
        userDataWhileUsingEntity.setUserDocumentTime(DateUtils.parseDate(userDataWhileUsingDto.getUserDocumentTime(), "yyyy-MM-dd"));
        userDataWhileUsingEntity.setUserId(loginUserEntity.getId());
        userDataWhileUsingEntity.setUserName(loginUserEntity.getUserName());

        UserDataWhileUsingEntity save = userDataWhileUsingService.save(userDataWhileUsingEntity);

        listSensorData(modelAndView, loginUser);
        return modelAndView;
    }

    @RequestMapping("/updateRecord/{userDocumentTime}")
    public ModelAndView updateRecord(ModelAndView modelAndView, HttpSession session,
                                     @PathVariable("userDocumentTime") String userDocumentTime) {
        LOGGER.info("userDocumentTime:{}", userDocumentTime);
        NewRedisUtils redisUtils = NewRedisUtils.getRedisUtil();
        String loginUser = (String) session.getAttribute("login_user");
        if (!StringUtils.isBlank(loginUser)) {
            UserInformationEntity userInfo = userInformationService.getUserInformationEntityByUserAccount(loginUser);
            LOGGER.info("updateRecord userInfo:{}", gson.toJson(userInfo));
            String key = "location_info_" + userInfo.getUserAccount() + "_" + userDocumentTime.replace(".0", "").replace(" ", "_").replace("-", ":");
            LOGGER.info("updateRecord curDataStr:{}", key);
            String curDataStr = redisUtils.get(2, key);
            LOGGER.info("updateRecord curDataStr:{}", curDataStr);
            UserDataWhileUsingEntity curUserData = gson.fromJson(curDataStr, new TypeToken<UserDataWhileUsingEntity>() {
            }.getType());
            //redis中找不到再去mysql中找
            if (curUserData == null) {
                curUserData = userDataWhileUsingService.getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(userDocumentTime.replace(".0", ""), userInfo.getId());
                LOGGER.info("updateRecord curUserData:{}", gson.toJson(curUserData));
            }
            LOGGER.info("updateRecord curUserData From Redis:{}", gson.toJson(curUserData));

            modelAndView.addObject("curUserData", curUserData);
        }
        modelAndView.setViewName("/update");
        return modelAndView;
    }

    @RequestMapping("/submitUpdateRecord")
    public ModelAndView submitUpdateRecord(HttpSession session,
                                           ModelAndView modelAndView,
                                           @Param("deviceId") Integer deviceId,
                                           @Param("userLocationX") String userLocationX,
                                           @Param("userLocationY") String userLocationY,
                                           @Param("userDocumentTime") String userDocumentTime,
                                           @Param("userOldDocumentTime") String userOldDocumentTime) throws ParseException {
        LOGGER.info("userOldDocumentTime:{}", userOldDocumentTime);
        String loginUser = (String) session.getAttribute("login_user");
        NewRedisUtils redisUtils = NewRedisUtils.getRedisUtil();
        if (!StringUtils.isBlank(loginUser)) {
            UserInformationEntity userInfo = userInformationService.getUserInformationEntityByUserAccount(loginUser);
            LOGGER.info("submitUpdateRecord userInfo:{}", gson.toJson(userInfo));
            // 某一个时间点某一个用户的记录
            String key = "location_info_" + userInfo.getUserAccount() + "_" + userOldDocumentTime.replace(".0", "").replace(" ", "_").replace("-", ":");
            LOGGER.info("submitUpdateRecord key:{}", key);
            String oldUserDataStr = redisUtils.get(2, key);
            LOGGER.info("submitUpdateRecord oldUserDataStr:{}", oldUserDataStr);
            UserDataWhileUsingEntity oldUserData = gson.fromJson(oldUserDataStr, new TypeToken<UserDataWhileUsingEntity>() {
            }.getType());
            if (oldUserData != null) {
                oldUserData = userDataWhileUsingService.getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(userDocumentTime.replace(".0", ""), userInfo.getId());
                LOGGER.info("submitUpdateRecord oldUserData:{}", gson.toJson(oldUserData));
                //必须new一个对象然后copyProperties，不然报错，报错原因和id有关
                UserDataWhileUsingEntity newUserData = getNewUserData(deviceId, userLocationX, userLocationY, userDocumentTime, oldUserData);
                userDataWhileUsingService.save(newUserData);
            } else {
                //必须new一个对象然后copyProperties，不然报错，报错原因和id有关
                UserDataWhileUsingEntity newUserData = getNewUserData(deviceId, userLocationX, userLocationY, userDocumentTime, oldUserData);
                redisUtils.del(2, key);
                //存入redis
                String result = redisUtils.set(2, "location_info_" + userInfo.getUserAccount() + "_" + DateFormatUtils.format(DateUtils.parseDate(userDocumentTime, "yyyy-MM-dd hh:mm:ss"), "yyyy:MM:dd_hh:mm:ss"),
                        gson.toJson(newUserData));
                LOGGER.info("initDataToRedis result:{}", result);
            }

        }
        listSensorData(modelAndView, loginUser);
        modelAndView.setViewName("/sensorinfo");
        return modelAndView;
    }

    private UserDataWhileUsingEntity getNewUserData(Integer deviceId, String userLocationX, String userLocationY, String userDocumentTime, UserDataWhileUsingEntity oldUserData) throws ParseException {
        UserDataWhileUsingEntity newUserData = new UserDataWhileUsingEntity();
        BeanUtils.copyProperties(oldUserData, newUserData);
        newUserData.setId(oldUserData.getId());
        newUserData.setDeviceId(deviceId);
        newUserData.setUserLocationX(new BigDecimal(userLocationX));
        newUserData.setUserLocationY(new BigDecimal(userLocationY));
        newUserData.setUserDocumentTime(DateUtils.parseDate(userDocumentTime.replace(".0", ""), "yyyy-MM-dd hh:mm:ss"));
        LOGGER.info("updateRecord newUserData:{}", gson.toJson(newUserData));
        return newUserData;
    }

    @RequestMapping("/removeRecord/{userDocumentTime}")
    public ModelAndView removeRecord(ModelAndView modelAndView, HttpSession session, @PathVariable("userDocumentTime") String userDocumentTime) {
        String loginUser = (String) session.getAttribute("login_user");
        if (!StringUtils.isBlank(loginUser)) {
            UserInformationEntity userInfo = userInformationService.getUserInformationEntityByUserAccount(loginUser);
            LOGGER.info("removeRecord userInfo:{}", gson.toJson(userInfo));
            // 某一个时间点某一个用户的记录
            UserDataWhileUsingEntity oldUserData = userDataWhileUsingService.getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(userDocumentTime.replace(".0", ""), userInfo.getId());
            LOGGER.info("removeRecord oldUserData:{}", gson.toJson(oldUserData));
            //必须new一个对象然后copyProperties，不然报错，报错原因和id有关
            userDataWhileUsingService.removeUserDataById(oldUserData.getId());
        }

        listSensorData(modelAndView, loginUser);
        modelAndView.setViewName("/sensorinfo");
        return modelAndView;
    }
}
