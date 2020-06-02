package com.shnu.work.repository;

import com.shnu.work.entity.UserInformationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface UserInformationRepository extends CrudRepository<UserInformationEntity, Integer> {
    /**
     * 根据用户账户查询某一条记录
     *
     * @param userAccount 用户账户
     * @return 这条记录
     */
    @Query(value = "SELECT * FROM user_information WHERE user_account = ?1", nativeQuery = true)
    UserInformationEntity getUserInformationEntityByUserAccount(String userAccount);
}
