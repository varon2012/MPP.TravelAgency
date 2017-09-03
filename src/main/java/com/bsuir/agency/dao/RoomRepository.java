package com.bsuir.agency.dao;

import com.bsuir.agency.entity.RoomEntity;

public interface RoomRepository extends BaseRepository {
    Iterable<RoomEntity> findAll();
    RoomEntity findById(int id);
    Iterable<RoomEntity> findByRoomId(int roomId);
    Iterable<RoomEntity> findByHotelId(int hotelId);
    void create(RoomEntity roomEntity);
    void update(RoomEntity roomEntity);
    void delete(RoomEntity roomEntity);
}
