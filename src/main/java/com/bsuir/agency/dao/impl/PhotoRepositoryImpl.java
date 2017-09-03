package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.BaseRepository;
import com.bsuir.agency.dao.PhotoRepository;
import com.bsuir.agency.entity.PhotoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PhotoRepositoryImpl extends BaseRepositoryImpl implements PhotoRepository {
    @Override
    public Iterable<PhotoEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PhotoEntity ");
        Iterable<PhotoEntity> photoEntities = query.list();
        return photoEntities;
    }

    @Override
    public PhotoEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PhotoEntity h where h.id = :id");
        query.setParameter("id", id);
        List<PhotoEntity> photoEntities = query.list();

        if (photoEntities.size() == 0){
            return null;
        }

        return photoEntities.get(0);
    }

    @Override
    public Iterable<PhotoEntity> findByRoomId(int roomId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PhotoEntity h where h.roomId = :name");
        query.setParameter("name", roomId);
        return query.list();
    }

    @Override
    public Iterable<PhotoEntity> findByInterestingPlaceId(int interestingPlaceId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PhotoEntity h where h.interestingPlaceId = :name");
        query.setParameter("name", interestingPlaceId);
        return query.list();
    }

    @Override
    public Iterable<PhotoEntity> findByUserId(int userID) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PhotoEntity h where h.userId = :name");
        query.setParameter("name", userID);
        return query.list();
    }

    @Override
    public void create(PhotoEntity photoEntity) {
        Session session = getCurrentSession();
        session.save(photoEntity);
    }

    @Override
    public void update(PhotoEntity photoEntity) {
        Session session = getCurrentSession();
        session.save(photoEntity);
    }

    @Override
    public void delete(PhotoEntity photoEntity) {
        Session session = getCurrentSession();
        session.save(photoEntity);
    }
}
