package com.shnu.work.repository;

import com.shnu.work.entity.UserInformationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface UserInformationRepository extends CrudRepository<Integer, UserInformationEntity> {
}
