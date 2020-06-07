package com.shnu.work.repository;

import com.shnu.work.entity.AdministrationInformationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface AdministrationInformationRepository extends CrudRepository<AdministrationInformationEntity, Long> {

    /**
     * 通过账号查找
     *
     * @param adminAccount 账号
     * @return 结果
     */
    @Query(value = "SELECT * FROM administration_information WHERE administration_account = ?1", nativeQuery = true)
    AdministrationInformationEntity getAdministrationInformationEntityByAdministrationAccount(String adminAccount);
}
