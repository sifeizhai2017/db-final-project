package com.shnu.work.repository;

import com.shnu.work.entity.SystemInformationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface SystemInformationRepository extends CrudRepository<SystemInformationEntity, Integer> {
}
