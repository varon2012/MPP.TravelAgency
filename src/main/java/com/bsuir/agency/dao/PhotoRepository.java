package com.bsuir.agency.dao;

import com.bsuir.agency.entity.PhotoEntity;

import java.util.List;

public interface PhotoRepository extends BaseRepository {
    Iterable<PhotoEntity> findAll();
    PhotoEntity findById(int id);
    Iterable<PhotoEntity> findByRoomId(int roomId);
    Iterable<PhotoEntity> findByInterestingPlaceId(int interestingPlaceId);
    Iterable<PhotoEntity> findByUserId(int userID);
    void create(PhotoEntity photoEntity);
    void update(PhotoEntity photoEntity);
    void delete(PhotoEntity photoEntity);
}
