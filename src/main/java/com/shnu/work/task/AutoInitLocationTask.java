package com.shnu.work.task;

import com.google.gson.Gson;
import com.shnu.work.repository.UserDataWhileUsingRepository;
import com.shnu.work.repository.UserInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

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

    @Scheduled(fixedRate = 10000)
    private void configureTasks() {
//        Iterable<UserInformationEntity> allUsers = userInformationRepository.findAll();
//        for (UserInformationEntity user : allUsers) {
//            Map<String, String> lonLatMap = RandomLocationUtils.randomLonLat(100, 200, 300, 40);
//            UserDataWhileUsingEntity userDataWhileUsingEntity = new UserDataWhileUsingEntity();
//            userDataWhileUsingEntity.setUserId(user.getUserId());
//            userDataWhileUsingEntity.setUserDocumentTime(new Date());
//            userDataWhileUsingEntity.setUserLocationX(new BigDecimal(lonLatMap.get("J")));
//            userDataWhileUsingEntity.setUserLocationY(new BigDecimal(lonLatMap.get("W")));
//            userDataWhileUsingEntity.setUserName(user.getUserName());
//            userDataWhileUsingEntity.setUserEmergencyContact(RandomStringUtils.randomNumeric(11));
//            userDataWhileUsingEntity.setUserHealthCareDemo(RandomStringUtils.randomAlphabetic(12));
//            userDataWhileUsingEntity.setDocumentAlert(1);
//            userDataWhileUsingRepository.save(userDataWhileUsingEntity);
//        }

        LOGGER.info("执行静态定时任务时间：" + LocalDateTime.now());
    }
}
