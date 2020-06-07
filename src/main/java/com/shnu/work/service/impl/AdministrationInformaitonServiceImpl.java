package com.shnu.work.service.impl;

import com.shnu.work.entity.AdministrationInformationEntity;
import com.shnu.work.repository.AdministrationInformationRepository;
import com.shnu.work.service.IAdministrationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Shinomiya Kaguya
 */
@Service
public class AdministrationInformaitonServiceImpl implements IAdministrationInformationService {
    @Autowired
    AdministrationInformationRepository administrationInformationRepository;

    @Override
    public AdministrationInformationEntity getAdministrationInformationEntityByAdministrationAccount(String adminAccount) {
        return administrationInformationRepository.getAdministrationInformationEntityByAdministrationAccount(adminAccount);
    }
}
