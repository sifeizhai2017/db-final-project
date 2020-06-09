package com.shnu.work.task;

import com.google.gson.Gson;
import com.shnu.work.entity.UserDataWhileUsingEntity;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.enums.HealthConditionEnum;
import com.shnu.work.repository.UserDataWhileUsingRepository;
import com.shnu.work.repository.UserInformationRepository;
import com.shnu.work.util.NewRedisUtils;
import com.shnu.work.util.RandomLocationUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
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

//    @Scheduled(cron = "*/5 * * * * *")
//    @Scheduled(fixedRate = 1000)
    private void initDataToRedis() {
        LOGGER.info("=========================随机生成数据插入到redis开始===========================");
        NewRedisUtils redisUtils = NewRedisUtils.getRedisUtil();
        //写到redis中，每2分钟更新将缓存清到mysql中
        Iterable<UserInformationEntity> allUsers = userInformationRepository.findAll();
        for (UserInformationEntity user : allUsers) {
            try {
                Map<String, String> lonLatMap = RandomLocationUtils.randomLonLat(100, 200, 300, 40);
                UserDataWhileUsingEntity userDataWhileUsingEntity = new UserDataWhileUsingEntity();
                userDataWhileUsingEntity.setUserId(user.getId());
                userDataWhileUsingEntity.setUserDocumentTime(new Date());
                userDataWhileUsingEntity.setUserLocationX(new BigDecimal(Objects.requireNonNull(lonLatMap).get("J")).abs());
                userDataWhileUsingEntity.setUserLocationY(new BigDecimal(lonLatMap.get("W")).abs());
                userDataWhileUsingEntity.setUserName(user.getUserName());
                userDataWhileUsingEntity.setIsDeleted(0);

                // 生成13开头的手机号
                userDataWhileUsingEntity.setUserEmergencyContact("13" + RandomStringUtils.randomNumeric(9));
                // 随机生成健康状况
                userDataWhileUsingEntity.setUserHealthCareDemo(HealthConditionEnum.getEmByKey((int) (Math.random() * 3)).getValue());
                userDataWhileUsingEntity.setDocumentAlert(1);
                //存入redis
                String result = redisUtils.set(2, "location_info_" + user.getUserAccount() + "_" + DateFormatUtils.format(userDataWhileUsingEntity.getUserDocumentTime(), "yyyy:MM:dd_hh:mm:ss"),
                        gson.toJson(userDataWhileUsingEntity));
                LOGGER.info("initDataToRedis result:{}", result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("=========================随机生成数据插入到redis开始===========================");
    }


//    @Scheduled(cron = "*/60 * * * * *")
//    @Scheduled(fixedRate = 10000)
    private void flushDataToMySql() {
        LOGGER.info("=========================从redis中取数据插入到mysql开始===========================");
        NewRedisUtils redisUtils = NewRedisUtils.getRedisUtil();
        //每隔2分钟把所有location_info开头的数据写到mysql中，并删除调这些结果
        Set<String> locationInfoCacheSet = redisUtils.keys(2, "location_info_*");
        LOGGER.info("flushDataToMySql locationInfoCacheSet:{}", gson.toJson(locationInfoCacheSet));
        locationInfoCacheSet.forEach(locationInfoCache -> {
            String locationData = redisUtils.get(2, locationInfoCache);
            UserDataWhileUsingEntity locationDataEntity = gson.fromJson(locationData, UserDataWhileUsingEntity.class);
            userDataWhileUsingRepository.save(locationDataEntity);
            Long delete = redisUtils.del(2, locationInfoCache);
            LOGGER.info("flushDataToMySql delete:{}", delete);
        });
        LOGGER.info("=========================从redis中取数据插入到mysql结束===========================");
    }
}
