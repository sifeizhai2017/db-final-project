package com.shnu.work.task;

import com.google.gson.Gson;
import com.shnu.work.entity.UserDataWhileUsingEntity;
import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.repository.UserDataWhileUsingRepository;
import com.shnu.work.repository.UserInformationRepository;
import com.shnu.work.util.RandomLocationUtils;
import org.apache.commons.lang3.RandomStringUtils;
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

/**
 * 定时任务：自动生成经纬度信息
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

    @Scheduled(fixedRate = Integer.MAX_VALUE)
    private void configureTasks() {
        Iterable<UserInformationEntity> allUsers = userInformationRepository.findAll();
        for (UserInformationEntity user : allUsers) {
            try {
                Map<String, String> lonLatMap = RandomLocationUtils.randomLonLat(100, 200, 300, 40);
                UserDataWhileUsingEntity userDataWhileUsingEntity = new UserDataWhileUsingEntity();
                userDataWhileUsingEntity.setUserId(user.getId());
                userDataWhileUsingEntity.setUserDocumentTime(new Date());
                userDataWhileUsingEntity.setUserLocationX(new BigDecimal(Objects.requireNonNull(lonLatMap).get("J")));
                userDataWhileUsingEntity.setUserLocationY(new BigDecimal(lonLatMap.get("W")));
                userDataWhileUsingEntity.setUserName(user.getUserName());
                userDataWhileUsingEntity.setUserEmergencyContact(RandomStringUtils.randomNumeric(11));
                userDataWhileUsingEntity.setUserHealthCareDemo(RandomStringUtils.randomAlphabetic(12));
                userDataWhileUsingEntity.setDocumentAlert(1);
                userDataWhileUsingRepository.save(userDataWhileUsingEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        LOGGER.info("执行静态定时任务时间：" + LocalDateTime.now());
    }
}
