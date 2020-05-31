package com.shnu.work.repository;

import com.shnu.work.entity.AdministrationInformationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface AdministrationInformationRepository extends CrudRepository<Integer, AdministrationInformationEntity> {
}
