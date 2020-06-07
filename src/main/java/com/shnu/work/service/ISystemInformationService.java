package com.shnu.work.service;

import com.shnu.work.entity.SystemInformationEntity;

import java.util.Optional;

/**
 * @author Shinomiya Kaguya
 */
public interface ISystemInformationService {
    /**
     * 通过id查询
     * @param id id
     * @return 结果
     */
    Optional<SystemInformationEntity> getSysInfoById(Long id);
}
