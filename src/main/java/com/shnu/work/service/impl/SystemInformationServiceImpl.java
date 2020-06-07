package com.shnu.work.service.impl;

import com.shnu.work.entity.SystemInformationEntity;
import com.shnu.work.repository.SystemInformationRepository;
import com.shnu.work.service.ISystemInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Shinomiya Kaguya
 */
@Service
public class SystemInformationServiceImpl implements ISystemInformationService {
    @Autowired
    SystemInformationRepository systemInformationRepository;

    @Override
    public Optional<SystemInformationEntity> getSysInfoById(Long id) {
        return systemInformationRepository.findById(id);
    }
}
