package com.shnu.work.service;

import com.shnu.work.entity.UserDataWhileUsingEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Shinomiya Kaguya
 */
public interface IUserDataWhileUsingService {
    /**
     * 根据userId查到所有结果
     *
     * @param userId userId
     * @return 所有结果
     */
    List<UserDataWhileUsingEntity> listUserDataWhileUsingEntitiesByUserId(Long userId);

    /**
     * 保存一条记录
     *
     * @param userDataWhileUsingEntity UserDataWhileUsingEntity
     * @return UserDataWhileUsingEntity
     */
    UserDataWhileUsingEntity save(UserDataWhileUsingEntity userDataWhileUsingEntity);

    /**
     * 根据userDocumentTime和userId查到结果
     *
     * @param userDocumentTime userDocumentTime
     * @param userId           userId
     * @return 结果
     */
    UserDataWhileUsingEntity getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(String userDocumentTime, Long userId);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 影响行数
     */
    Integer removeUserDataById(Long id);

    /**
     * 查找未删除的结果
     *
     * @return 结果list
     */
    List<UserDataWhileUsingEntity> listAllUndeleted();
}
