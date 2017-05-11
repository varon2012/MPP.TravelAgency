package com.bsuir.agency.dao;

import com.bsuir.agency.entity.RepresentativeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public interface RepresentativeRepository extends BaseRepository {
    Iterable<RepresentativeEntity> findAll();
    RepresentativeEntity findById(int id);
    RepresentativeEntity findByPersonId(int id);
    Iterable<RepresentativeEntity> findByCountry(String country);
    Iterable<RepresentativeEntity> findByCity(String city);
    void create(RepresentativeEntity representativeEntity);
    void update(RepresentativeEntity representativeEntity);
    void delete(RepresentativeEntity representativeEntity);
}
