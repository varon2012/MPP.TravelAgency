package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.RepresentativeRepository;
import com.bsuir.agency.entity.RepresentativeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public class RepresentativeRepositoryImpl extends BaseRepositoryImpl implements RepresentativeRepository {
    @Override
    public Iterable<RepresentativeEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeEntity");
        Iterable<RepresentativeEntity> list = query.list();
        return list;
    }

    @Override
    public RepresentativeEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeEntity r where r.representativeId = :id");
        query.setParameter("id", id);
        List<RepresentativeEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public RepresentativeEntity findByPersonId(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeEntity r where r.representativeUserId = :id");
        query.setParameter("id", id);
        List<RepresentativeEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public Iterable<RepresentativeEntity> findByCountry(String country) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeEntity r where r.country = :country");
        query.setParameter("country", country);
        Iterable<RepresentativeEntity> list = query.list();
        return list;
    }

    @Override
    public Iterable<RepresentativeEntity> findByCity(String city) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeEntity r where r.city = :city");
        query.setParameter("city", city);
        Iterable<RepresentativeEntity> list = query.list();
        return list;
    }

    @Override
    public void create(RepresentativeEntity representativeEntity) {
        Session session = getCurrentSession();
        session.save(representativeEntity);
    }

    @Override
    public void update(RepresentativeEntity representativeEntity) {
        Session session = getCurrentSession();
        session.update(representativeEntity);
    }

    @Override
    public void delete(RepresentativeEntity representativeEntity) {
        Session session = getCurrentSession();
        session.delete(representativeEntity);
    }
}
