package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.RoomRepository;
import com.bsuir.agency.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomRepositoryImpl extends BaseRepositoryImpl implements RoomRepository {
    @Override
    public Iterable<RoomEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomEntity ");
        return query.list();
    }

    @Override
    public RoomEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomEntity h where h.id = :id");
        query.setParameter("id", id);
        List<RoomEntity> photoEntities = query.list();

        if (photoEntities.size() == 0){
            return null;
        }

        return photoEntities.get(0);
    }

    @Override
    public Iterable<RoomEntity> findByRoomId(int roomId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomEntity h where h.roomId = :room");
        query.setParameter("room", roomId);
        return query.list();
    }

    @Override
    public Iterable<RoomEntity> findByHotelId(int hotelId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomEntity h where h.hotelId = :hotel");
        query.setParameter("hotel", hotelId);
        return query.list();
    }

    @Override
    public void create(RoomEntity roomEntity) {
        Session session = getCurrentSession();
        session.save(roomEntity);
    }

    @Override
    public void update(RoomEntity roomEntity) {
        Session session = getCurrentSession();
        session.update(roomEntity);
    }

    @Override
    public void delete(RoomEntity roomEntity) {
        Session session = getCurrentSession();
        session.delete(roomEntity);
    }
}
