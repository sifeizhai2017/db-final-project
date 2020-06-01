package com.shnu.work.service;

import com.shnu.work.entity.UserInformationEntity;
import org.springframework.stereotype.Service;

/**
 * @author Shinomiya Kaguya
 */
public interface IUserInformationService {

    /**
     * 添加新的用户
     * @param user
     * @return
     */
    UserInformationEntity saveNewUser(UserInformationEntity user);
}
