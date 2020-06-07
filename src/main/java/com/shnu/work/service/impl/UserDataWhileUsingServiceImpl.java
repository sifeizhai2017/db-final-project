package com.shnu.work.service.impl;

import com.shnu.work.entity.UserDataWhileUsingEntity;
import com.shnu.work.repository.UserDataWhileUsingRepository;
import com.shnu.work.service.IUserDataWhileUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public UserDataWhileUsingEntity save(UserDataWhileUsingEntity userDataWhileUsingEntity) {
        return userDataWhileUsingRepository.save(userDataWhileUsingEntity);
    }

    @Override
    public UserDataWhileUsingEntity getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(String userDocumentTime, Long userId) {
        return userDataWhileUsingRepository.getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(userDocumentTime, userId);
    }

    @Override
    public Integer removeUserDataById(Long id) {
        return userDataWhileUsingRepository.removeUserDataById(id);
    }

    @Override
    public List<UserDataWhileUsingEntity> listAllUndeleted() {
        return this.userDataWhileUsingRepository.listAllUndeleted();
    }
}
