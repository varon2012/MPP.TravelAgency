package com.bsuir.agency.dao;

import com.bsuir.agency.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public interface UserRepository {
    Iterable<UserEntity> findAll();
    UserEntity findById(int id);
    UserEntity findPersonId(int id);
    void create(UserEntity userEntity);
    void update(UserEntity userEntity);
    void delete(UserEntity userEntity);
}
