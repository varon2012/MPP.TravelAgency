package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.InterestingPlacesRepository;
import com.bsuir.agency.entity.InterestingplacesEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class InterestingPlaceRepositoryImpl extends BaseRepositoryImpl implements InterestingPlacesRepository {
    @Override
    public Iterable<InterestingplacesEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from InterestingplacesEntity ");
        Iterable<InterestingplacesEntity> hotelEntities = query.list();
        return hotelEntities;
    }

    @Override
    public InterestingplacesEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from InterestingplacesEntity h where h.interestingPlaceId = :id");
        query.setParameter("id", id);
        List<InterestingplacesEntity> interestingplacesEntities = query.list();

        if (interestingplacesEntities.size() == 0){
            return null;
        }

        return interestingplacesEntities.get(0);
    }

    @Override
    public Iterable<InterestingplacesEntity> findByExcursionId(int excursionId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from InterestingplacesEntity h where h.excursionId = :name");
        query.setParameter("name", excursionId);
        return query.list();
    }

    @Override
    public void create(InterestingplacesEntity interestingplacesEntity) {
        Session session = getCurrentSession();
        session.save(interestingplacesEntity);
    }

    @Override
    public void update(InterestingplacesEntity interestingplacesEntity) {
        Session session = getCurrentSession();
        session.update(interestingplacesEntity);
    }

    @Override
    public void delete(InterestingplacesEntity interestingplacesEntity) {
        Session session = getCurrentSession();
        session.delete(interestingplacesEntity);
    }
}
