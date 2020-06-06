package com.shnu.work.task;

import com.google.gson.Gson;
import com.shnu.work.entity.UserDataWhileUsingEntity;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.enums.HealthConditionEnum;
import com.shnu.work.repository.UserDataWhileUsingRepository;
import com.shnu.work.repository.UserInformationRepository;
import com.shnu.work.util.RandomLocationUtils;
import com.shnu.work.util.RedisUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 定时任务：自动生成经纬度信息
 *
 * @author Shinomiya Kaguya
 */
@Configuration
@EnableScheduling
public class AutoInitLocationTask {
    @Autowired
    UserInformationRepository userInformationRepository;
    @Autowired
    UserDataWhileUsingRepository userDataWhileUsingRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(AutoInitLocationTask.class);
    private final Gson gson = new Gson();

    @Autowired
    RedisUtils redisUtils;

    @Scheduled(fixedRate = Integer.MAX_VALUE)
    private void initDataToRedis() {
        //写到redis中，每2分钟更新将缓存清到mysql中
        Iterable<UserInformationEntity> allUsers = userInformationRepository.findAll();
        redisUtils.switchDatabase(1);
        for (UserInformationEntity user : allUsers) {
            try {
                Map<String, String> lonLatMap = RandomLocationUtils.randomLonLat(100, 200, 300, 40);
                UserDataWhileUsingEntity userDataWhileUsingEntity = new UserDataWhileUsingEntity();
                userDataWhileUsingEntity.setUserId(user.getId());
                userDataWhileUsingEntity.setUserDocumentTime(new Date());
                userDataWhileUsingEntity.setUserLocationX(new BigDecimal(Objects.requireNonNull(lonLatMap).get("J")).abs());
                userDataWhileUsingEntity.setUserLocationY(new BigDecimal(lonLatMap.get("W")).abs());
                userDataWhileUsingEntity.setUserName(user.getUserName());

                // 生成13开头的手机号
                userDataWhileUsingEntity.setUserEmergencyContact("13" + RandomStringUtils.randomNumeric(9));
                // 随机生成健康状况
                userDataWhileUsingEntity.setUserHealthCareDemo(HealthConditionEnum.getEmByKey((int) (Math.random() * 3)).getValue());
                userDataWhileUsingEntity.setDocumentAlert(1);
                userDataWhileUsingRepository.save(userDataWhileUsingEntity);
                //存入数据库
//                boolean result = redisUtils.set("location_info_" + user.getUserAccount() + "_" + DateFormatUtils.format(userDataWhileUsingEntity.getUserDocumentTime(), "yyyy:MM:dd_hh:mm:ss"),
//                        gson.toJson(userDataWhileUsingEntity));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        LOGGER.info("执行静态定时任务时间：" + LocalDateTime.now());
    }

    @Scheduled(fixedRate = 60000)
    private void flushDataToMySql() {
        //每隔2分钟把所有location_info开头的数据写到mysql中，并删除调这些结果
//        Set<String> locationInfoCacheSet = redisUtils.fuzzySearch("*location_info_*");
//        for (String locationInfoCache : locationInfoCacheSet) {
//            String locationData = redisUtils.get(locationInfoCache);
//            UserDataWhileUsingEntity locationDataEntity = gson.fromJson(locationData, UserDataWhileUsingEntity.class);
//            userDataWhileUsingRepository.save(locationDataEntity);
//            boolean delete = redisUtils.delete(locationInfoCache);
//        }
    }
}
