package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.ReviewRepository;
import com.bsuir.agency.entity.ReviewEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
public class ReviewRepositoryImpl extends BaseRepositoryImpl implements ReviewRepository {
    @Override
    public Iterable<ReviewEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("From ReviewEntity ");
        Iterable<ReviewEntity> reviewEntities = query.list();
        return reviewEntities;
    }

    @Override
    public ReviewEntity findReviewById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from ReviewEntity r where r.reviewId = :id");
        query.setParameter("id", id);
        List<ReviewEntity> reviewEntities = query.list();

        if (reviewEntities.size() == 0){
            return null;
        }

        return reviewEntities.get(0);
    }

    @Override
    public Iterable<ReviewEntity> findReviewsByUserId(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from ReviewEntity r where r.userId = :id");
        query.setParameter("id", id);
        List<ReviewEntity> reviewEntities = query.list();
        return reviewEntities;
    }

    @Override
    public Iterable<ReviewEntity> findReviewsByTourId(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from ReviewEntity r where r.tourId = :id");
        query.setParameter("id", id);
        List<ReviewEntity> reviewEntities = query.list();
        return reviewEntities;
    }

    @Override
    public void create(ReviewEntity reviewEntity) {
        Session session = getCurrentSession();
        session.save(reviewEntity);
    }

    @Override
    public void update(ReviewEntity reviewEntity) {
        Session session = getCurrentSession();
        session.update(reviewEntity);
    }

    @Override
    public void delete(ReviewEntity reviewEntity) {
        Session session = getCurrentSession();
        session.delete(reviewEntity);
    }
}
