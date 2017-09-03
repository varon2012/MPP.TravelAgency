package com.bsuir.agency.dao;

import com.bsuir.agency.entity.InterestingplacesEntity;

public interface InterestingPlacesRepository extends BaseRepository {
    Iterable<InterestingplacesEntity> findAll();
    InterestingplacesEntity findById(int id);
    Iterable<InterestingplacesEntity> findByExcursionId(int excursionId);
    void create(InterestingplacesEntity interestingplacesEntity);
    void update(InterestingplacesEntity interestingplacesEntity);
    void delete(InterestingplacesEntity interestingplacesEntity);
}
