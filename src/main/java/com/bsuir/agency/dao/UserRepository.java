package com.bsuir.agency.dao;

import com.bsuir.agency.entity.UserEntity;
import com.bsuir.agency.entity.UserinfoEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public interface UserRepository extends BaseRepository{
    Iterable<UserinfoEntity> findAll();
    UserinfoEntity findById(int id);
    UserinfoEntity findByPersonId(int id);
    Iterable<UserinfoEntity> findByName(String name);
    Iterable<UserinfoEntity> findBySurname(String surname);
    Iterable<UserinfoEntity> findByPatronymic(String patronymic);
    Iterable<UserinfoEntity> findByNameAndSurname(String name, String surname);
    Iterable<UserinfoEntity> findByNameAndPatronymic(String name, String patronymic);
    Iterable<UserinfoEntity> findByFullNme(String name, String surname, String patronymic);
    void create(UserinfoEntity userEntity);
    void update(UserinfoEntity userEntity);
    void delete(UserinfoEntity userEntity);
}
