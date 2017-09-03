package com.bsuir.agency.dao;

import com.bsuir.agency.entity.FavouriteEntity;

public interface FavouriteRepository extends BaseRepository{
    Iterable<FavouriteEntity> findAll();
    FavouriteEntity findById(int id);
    Iterable<FavouriteEntity> findByUserId(int userId);
    Iterable<FavouriteEntity> findByTourId(int tourId);
    void create(FavouriteEntity entity);
    void update(FavouriteEntity entity);
    void delete(FavouriteEntity entity);
}
