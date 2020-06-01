package com.shnu.work.repository;

import com.shnu.work.entity.UserDataWhileUsingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface UserDataWhileUsingRepository extends CrudRepository<UserDataWhileUsingEntity, Integer> {
}
