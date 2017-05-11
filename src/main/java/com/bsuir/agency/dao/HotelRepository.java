package com.bsuir.agency.dao;

import com.bsuir.agency.entity.HotelEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public interface HotelRepository extends BaseRepository {
    Iterable<HotelEntity> findAll();
    HotelEntity findById(int id);
    Iterable<HotelEntity> findByStars(int stars);
    Iterable<HotelEntity> findByRepresentativeId(int id);
    void create(HotelEntity hotelEntity);
    void update(HotelEntity hotelEntity);
    void delete(HotelEntity hotelEntity);
}
