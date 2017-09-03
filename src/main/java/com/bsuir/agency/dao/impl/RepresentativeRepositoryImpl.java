package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.RepresentativeRepository;
import com.bsuir.agency.entity.RepresentativeinfoEntity;
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
    public Iterable<RepresentativeinfoEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeinfoEntity");
        Iterable<RepresentativeinfoEntity> list = query.list();
        return list;
    }

    @Override
    public RepresentativeinfoEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeinfoEntity r where r.representativeId = :id");
        query.setParameter("id", id);
        List<RepresentativeinfoEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public RepresentativeinfoEntity findByPersonId(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeinfoEntity r where r.representativeUserId = :id");
        query.setParameter("id", id);
        List<RepresentativeinfoEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public RepresentativeinfoEntity findByOrgNumber(String orgNumber) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeinfoEntity r where r.organizationNumber = :id");
        query.setParameter("id", orgNumber);
        List<RepresentativeinfoEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public RepresentativeinfoEntity findByOrgName(String orgName) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeinfoEntity r where r.organizationName = :name");
        query.setParameter("name", orgName);
        List<RepresentativeinfoEntity> list = query.list();

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    @Override
    public Iterable<RepresentativeinfoEntity> findByCountry(String country) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeinfoEntity r where r.country = :country");
        query.setParameter("country", country);
        Iterable<RepresentativeinfoEntity> list = query.list();
        return list;
    }

    @Override
    public Iterable<RepresentativeinfoEntity> findByCity(String city) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RepresentativeinfoEntity r where r.city = :city");
        query.setParameter("city", city);
        Iterable<RepresentativeinfoEntity> list = query.list();
        return list;
    }

    @Override
    public void create(RepresentativeinfoEntity RepresentativeinfoEntity) {
        Session session = getCurrentSession();
        session.save(RepresentativeinfoEntity);
    }

    @Override
    public void update(RepresentativeinfoEntity RepresentativeinfoEntity) {
        Session session = getCurrentSession();
        session.update(RepresentativeinfoEntity);
    }

    @Override
    public void delete(RepresentativeinfoEntity RepresentativeinfoEntity) {
        Session session = getCurrentSession();
        session.delete(RepresentativeinfoEntity);
    }
}
