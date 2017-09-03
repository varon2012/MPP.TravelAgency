package com.bsuir.agency.dao;

import com.bsuir.agency.entity.TourEntity;

public interface TourRepository {
    Iterable<TourEntity> findAll();
    TourEntity findById(int id);
    Iterable<TourEntity> findByRepresentativeId(int representativeId);
    Iterable<TourEntity> findByExcursionId(int exursionId);
    void create(TourEntity tourEntity);
    void update(TourEntity tourEntity);
    void delete(TourEntity tourEntity);
}
