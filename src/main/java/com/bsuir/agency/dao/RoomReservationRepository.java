package com.bsuir.agency.dao;

import com.bsuir.agency.entity.RoomreservationEntity;

public interface RoomReservationRepository extends BaseRepository {
    Iterable<RoomreservationEntity> findAll();
    RoomreservationEntity findById(int id);
    Iterable<RoomreservationEntity> findByRoomId(int roomId);
    Iterable<RoomreservationEntity> findByUserId(int userId);
    void create(RoomreservationEntity roomreservationEntity);
    void update(RoomreservationEntity roomreservationEntity);
    void delete(RoomreservationEntity roomreservationEntity);
}
