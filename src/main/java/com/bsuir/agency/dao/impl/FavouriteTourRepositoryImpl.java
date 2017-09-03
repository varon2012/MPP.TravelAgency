package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.BaseRepository;
import com.bsuir.agency.dao.FavouriteRepository;
import com.bsuir.agency.entity.FavouriteEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FavouriteTourRepositoryImpl extends BaseRepositoryImpl implements FavouriteRepository {
    @Override
    public Iterable<FavouriteEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from FavouriteEntity ");
        Iterable<FavouriteEntity> excursionEntities  = query.list();
        return excursionEntities;
    }

    @Override
    public FavouriteEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from FavouriteEntity h where h.id = :id");
        query.setParameter("id", id);
        List<FavouriteEntity> favouriteEntities = query.list();

        if (favouriteEntities.size() == 0){
            return null;
        }

        return favouriteEntities.get(0);
    }

    @Override
    public Iterable<FavouriteEntity> findByUserId(int userId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from FavouriteEntity h where h.userId = :id");
        query.setParameter("id", userId);
        return query.list();
    }

    @Override
    public Iterable<FavouriteEntity> findByTourId(int tourId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from FavouriteEntity h where h.tourId = :id");
        query.setParameter("id", tourId);
        return query.list();
    }

    @Override
    public void create(FavouriteEntity entity) {
        Session session = getCurrentSession();
        session.save(entity);
    }

    @Override
    public void update(FavouriteEntity entity) {
        Session session = getCurrentSession();
        session.update(entity);
    }

    @Override
    public void delete(FavouriteEntity entity) {
        Session session = getCurrentSession();
        session.delete(entity);
    }
}
