package com.shnu.work.repository;

import com.shnu.work.entity.UserDataWhileUsingEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface UserDataWhileUsingRepository extends CrudRepository<UserDataWhileUsingEntity, Integer> {
    /**
     * 根据userId查到所有结果
     *
     * @param userId userId
     * @return 所有结果
     */
    @Query(value = "SELECT * FROM user_data_while_using WHERE user_id = ?1", nativeQuery = true)
    List<UserDataWhileUsingEntity> listUserDataWhileUsingEntitiesByUserId(Long userId);

    /**
     * 根据userDocumentTime和userId查到结果
     *
     * @param userDocumentTime userDocumentTime
     * @param userId           userId
     * @return 结果
     */
    @Query(value = "SELECT * FROM user_data_while_using WHERE user_document_time = ?1 AND user_id = ?2", nativeQuery = true)
    UserDataWhileUsingEntity getUserDataWhileUsingEntityByUserDocumentTimeAndUserId(Date userDocumentTime, Long userId);

    /**
     * 更新
     *
     * @param deviceId         设备id
     * @param userLocationX    纬度
     * @param userLocationY    经度
     * @param userDocumentTime 时间戳
     * @param id               查询条件
     * @return
     */
    @Modifying
    @Query(value = "UPDATE user_data_while_using SET device_id = ?1, user_location_x = ?2, user_location_y = ?3, user_document_time = ?3 WHERE id = ?4", nativeQuery = true)
    Integer updateByDocumentTimeAndUserId(long deviceId, BigDecimal userLocationX, BigDecimal userLocationY, Date userDocumentTime, long id);
}
