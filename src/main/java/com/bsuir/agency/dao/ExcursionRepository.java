package com.bsuir.agency.dao;

import com.bsuir.agency.entity.ExcursionEntity;

public interface ExcursionRepository extends BaseRepository {
    Iterable<ExcursionEntity> findAll();
    ExcursionEntity findById(int id);
    Iterable<ExcursionEntity> findByRepresentativeId(int representativeId);
    void create(ExcursionEntity entity);
    void update(ExcursionEntity entity);
    void delete(ExcursionEntity entity);
}
