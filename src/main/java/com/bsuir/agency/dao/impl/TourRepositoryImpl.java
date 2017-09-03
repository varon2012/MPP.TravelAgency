package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.TourRepository;
import com.bsuir.agency.entity.TourEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TourRepositoryImpl extends BaseRepositoryImpl implements TourRepository {
    @Override
    public Iterable<TourEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from TourEntity ");
        return query.list();
    }

    @Override
    public TourEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from TourEntity h where h.id = :id");
        query.setParameter("id", id);
        List<TourEntity> tourEntities = query.list();

        if (tourEntities.size() == 0){
            return null;
        }

        return tourEntities.get(0);
    }

    @Override
    public Iterable<TourEntity> findByRepresentativeId(int representativeId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from TourEntity h where h.representativeId = :representativeId");
        query.setParameter("representativeId", representativeId);
        return query.list();
    }

    @Override
    public Iterable<TourEntity> findByExcursionId(int exursionId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from TourEntity h where h.excursionId = :excursionId");
        query.setParameter("excursionId", exursionId);
        return query.list();
    }

    @Override
    public void create(TourEntity tourEntity) {
        Session session = getCurrentSession();
        session.save(tourEntity);
    }

    @Override
    public void update(TourEntity tourEntity) {
        Session session = getCurrentSession();
        session.update(tourEntity);
    }

    @Override
    public void delete(TourEntity tourEntity) {
        Session session = getCurrentSession();
        session.delete(tourEntity);
    }
}
