package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.RoomReservationRepository;
import com.bsuir.agency.entity.RoomreservationEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomReservationRepositoryImpl extends BaseRepositoryImpl implements RoomReservationRepository {
    @Override
    public Iterable<RoomreservationEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomreservationEntity ");
        return query.list();
    }

    @Override
    public RoomreservationEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomreservationEntity h where h.id = :id");
        query.setParameter("id", id);
        List<RoomreservationEntity> photoEntities = query.list();

        if (photoEntities.size() == 0){
            return null;
        }

        return photoEntities.get(0);
    }

    @Override
    public Iterable<RoomreservationEntity> findByRoomId(int roomId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomreservationEntity h where h.roomId = :room");
        query.setParameter("room", roomId);
        return query.list();
    }

    @Override
    public Iterable<RoomreservationEntity> findByUserId(int userId) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from RoomreservationEntity h where h.userId = :user");
        query.setParameter("user", userId);
        return query.list();
    }

    @Override
    public void create(RoomreservationEntity roomreservationEntity) {
        Session session = getCurrentSession();
        session.save(roomreservationEntity);
    }

    @Override
    public void update(RoomreservationEntity roomreservationEntity) {
        Session session = getCurrentSession();
        session.update(roomreservationEntity);
    }

    @Override
    public void delete(RoomreservationEntity roomreservationEntity) {
        Session session = getCurrentSession();
        session.delete(roomreservationEntity);
    }
}
