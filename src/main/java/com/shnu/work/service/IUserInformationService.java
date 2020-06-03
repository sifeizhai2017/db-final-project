package com.shnu.work.service;

import com.shnu.work.entity.UserInformationEntity;

/**
 * @author Shinomiya Kaguya
 */
public interface IUserInformationService {

    /**
     * 添加新的用户
     * @param user
     * @return
     */
    UserInformationEntity saveUser(UserInformationEntity user);

    /**
     * 根据用户账户查询某一条记录
     *
     * @param userAccount 用户账户
     * @return 这条记录
     */
    UserInformationEntity getUserInformationEntityByUserAccount(String userAccount);
}
