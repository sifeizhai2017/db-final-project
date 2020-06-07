package com.shnu.work.service;

import com.shnu.work.entity.AdministrationInformationEntity;

/**
 * @author Jason Bourne
 */
public interface IAdministrationInformationService {
    /**
     * 通过账号查找
     *
     * @param adminAccount 账号
     * @return 结果
     */
    AdministrationInformationEntity getAdministrationInformationEntityByAdministrationAccount(String adminAccount);
}
