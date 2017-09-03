package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.BaseRepository;
import com.bsuir.agency.dao.ExcursionRepository;
import com.bsuir.agency.entity.ExcursionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ExcursionRepositoryImpl extends BaseRepositoryImpl implements ExcursionRepository{

    @Override
    public Iterable<ExcursionEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from ExcursionEntity ");
        Iterable<ExcursionEntity> excursionEntities  = query.list();
        return excursionEntities;
    }

    @Override
    public ExcursionEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from ExcursionEntity h where h.id = :id");
        query.setParameter("id", id);
        List<ExcursionEntity> excursionEntities = query.list();

        if (excursionEntities.size() == 0){
            return null;
        }

        return excursionEntities.get(0);
    }

    @Override
    public Iterable<ExcursionEntity> findByRepresentativeId(int representativeId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from ExcursionEntity h where h.representativeId = :id");
        query.setParameter("id", representativeId);
        return query.list();
    }

    @Override
    public void create(ExcursionEntity entity) {
        Session session = getCurrentSession();
        session.save(entity);
    }

    @Override
    public void update(ExcursionEntity entity) {
        Session session = getCurrentSession();
        session.update(entity);
    }

    @Override
    public void delete(ExcursionEntity entity) {
        Session session = getCurrentSession();
        session.delete(entity);
    }
}