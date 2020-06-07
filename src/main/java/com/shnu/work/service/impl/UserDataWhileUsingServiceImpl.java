package com.shnu.work.service.impl;

import com.shnu.work.entity.UserDataWhileUsingEntity;
import com.shnu.work.repository.UserDataWhileUsingRepository;
import com.shnu.work.service.IUserDataWhileUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Shinomiya Kaguya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserDataWhileUsingServiceImpl implements IUserDataWhileUsingService {
    @Autowired
    UserDataWhileUsingRepository userDataWhileUsingRepository;

    @Override
    public List<UserDataWhileUsingEntity> listUserDataWhileUsingEntitiesByUserId(Long userId) {
        return this.userDataWhileUsingRepository.listUserDataWhileUsingEntitiesByUserId(userId);
    }

    @Override
    public Optional<UserDataWhileUsingEntity> findById(Integer id) {
        return this.userDataWhileUsingRepository.findById(id);
    }

    @Override
    public UserDataWhileUsingEntity save(UserDataWhileUsingEntity userDataWhileUsingEntity) {
        return userDataWhileUsingRepository.save(userDataWhileUsingEntity);
    }

    @Override
    public UserDataWhileUsingEntity getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(Date userDocumentTime, Long userId) {
        return userDataWhileUsingRepository.getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(userDocumentTime, userId);
    }

    @Override
    public Integer updateByDocumentTimeAndUserId(UserDataWhileUsingEntity newUserData, Long id) {
        return userDataWhileUsingRepository.updateByDocumentTimeAndUserId(newUserData.getDeviceId(),
                newUserData.getUserLocationX(),
                newUserData.getUserLocationY(),
                newUserData.getUserDocumentTime(),
                id);
    }
}
