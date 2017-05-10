package com.bsuir.agency.dao;

import com.bsuir.agency.entity.ReviewEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public interface ReviewRepository {
    Iterable<ReviewEntity> findAll();
    ReviewEntity findReviewById(int id);
    Iterable<ReviewEntity> findReviewsByUserId(int id);
    Iterable<ReviewEntity> findReviewsByTourId(int id);
    void create(ReviewEntity reviewEntity);
    void update(ReviewEntity reviewEntity);
    void delete(ReviewEntity reviewEntity);
}
