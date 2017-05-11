package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.UserRepository;
import com.bsuir.agency.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository {
    @Override
    public Iterable<UserEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserEntity");
        Iterable<UserEntity> entities = query.list();
        return entities;
    }

    @Override
    public UserEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserEntity u where u.userInfoId = :id");
        query.setParameter("id", id);
        List<UserEntity> entities = query.list();

        if (entities.size() == 0){
            return null;
        }

        return entities.get(0);
    }

    @Override
    public UserEntity findPersonId(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserEntity u where u.userId = :id");
        query.setParameter("id", id);
        List<UserEntity> entities = query.list();

        if (entities.size() == 0){
            return null;
        }

        return entities.get(0);
    }

    @Override
    public void create(UserEntity userEntity) {
        Session session = getCurrentSession();
        session.save(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        Session session = getCurrentSession();
        session.update(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        Session session = getCurrentSession();
        session.delete(userEntity);
    }

}
