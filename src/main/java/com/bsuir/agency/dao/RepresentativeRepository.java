package com.bsuir.agency.dao;

import com.bsuir.agency.entity.RepresentativeinfoEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public interface RepresentativeRepository extends BaseRepository {
    Iterable<RepresentativeinfoEntity> findAll();
    RepresentativeinfoEntity findById(int id);
    RepresentativeinfoEntity findByPersonId(int id);
    RepresentativeinfoEntity findByOrgNumber(String orgNumber);
    RepresentativeinfoEntity findByOrgName(String orgName);
    Iterable<RepresentativeinfoEntity> findByCountry(String country);
    Iterable<RepresentativeinfoEntity> findByCity(String city);
    void create(RepresentativeinfoEntity representativeEntity);
    void update(RepresentativeinfoEntity representativeEntity);
    void delete(RepresentativeinfoEntity representativeEntity);
}
