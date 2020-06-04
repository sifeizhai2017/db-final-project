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
     * 通过ID查询
     *
     * @param id id
     * @return 结果
     */
    Optional<UserDataWhileUsingEntity> findById(Integer id);

    /**
     * 保存一条记录
     *
     * @param userDataWhileUsingEntity UserDataWhileUsingEntity
     * @return UserDataWhileUsingEntity
     */
    UserDataWhileUsingEntity save(UserDataWhileUsingEntity userDataWhileUsingEntity);
}
