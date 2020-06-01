package com.shnu.work.repository;

import com.shnu.work.entity.DeepLearningDataDocumentsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shinomiya Kaguya
 */
@Repository
public interface DeepLearningDataDocumentsRepository extends CrudRepository<DeepLearningDataDocumentsEntity, Integer> {
}
