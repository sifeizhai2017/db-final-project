package com.shnu.work.service.impl;

import com.shnu.work.entity.UserInformationEntity;
import com.shnu.work.repository.UserInformationRepository;
import com.shnu.work.service.IUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Shinomiya Kaguya
 */
@Service
public class UserInformationServiceImpl implements IUserInformationService {
    @Autowired
    UserInformationRepository userInformationRepository;

    @Override
    public UserInformationEntity saveNewUser(UserInformationEntity user) {
        return userInformationRepository.save(user);
    }

    @Override
    public UserInformationEntity getUserInformationEntityByUserAccount(String userAccount) {
        return userInformationRepository.getUserInformationEntityByUserAccount(userAccount);
    }
}
