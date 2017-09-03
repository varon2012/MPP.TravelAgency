package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.HotelRepository;
import com.bsuir.agency.entity.HotelEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
public class HotelRepositoryImpl extends BaseRepositoryImpl implements HotelRepository {
    @Override
    public Iterable<HotelEntity> findAll() {
        Session session =getCurrentSession();
        Query query = session.createQuery("from HotelEntity ");
        Iterable<HotelEntity> hotelEntities = query.list();
        return hotelEntities;
    }

    @Override
    public HotelEntity findById(int id) {
        Session session =getCurrentSession();
        Query query = session.createQuery("from HotelEntity h where h.hotelId = :id");
        query.setParameter("id", id);
        List<HotelEntity> hotelEntities = query.list();

        if (hotelEntities.size() == 0){
            return null;
        }

        return hotelEntities.get(0);
    }

    @Override
    public HotelEntity findByName(String name) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from HotelEntity h where h.name = :name");
        query.setParameter("name", name);
        List<HotelEntity> hotelEntities = query.list();
        if (hotelEntities.size() == 0){
            return null;
        }
        return hotelEntities.get(0);
    }

    @Override
    public Iterable<HotelEntity> findByStars(int stars) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from HotelEntity h where h.stars = :stars");
        query.setParameter("stars", stars);
        Iterable<HotelEntity> hotelEntities = query.list();
        return hotelEntities;
    }

    @Override
    public Iterable<HotelEntity> findByRepresentativeId(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from HotelEntity h where h.representativeId = :id");
        query.setParameter("id", id);
        Iterable<HotelEntity> hotelEntities = query.list();
        return hotelEntities;
    }

    @Override
    public void create(HotelEntity hotelEntity) {
        Session session = getCurrentSession();
        session.save(hotelEntity);
    }

    @Override
    public void update(HotelEntity hotelEntity) {
        Session session = getCurrentSession();
        session.update(hotelEntity);
    }

    @Override
    public void delete(HotelEntity hotelEntity) {
        Session session = getCurrentSession();
        session.delete(hotelEntity);
    }
}
