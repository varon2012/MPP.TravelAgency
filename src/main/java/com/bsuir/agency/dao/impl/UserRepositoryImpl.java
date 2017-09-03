package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.UserRepository;
import com.bsuir.agency.entity.UserinfoEntity;
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
    public Iterable<UserinfoEntity> findAll() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity");
        Iterable<UserinfoEntity> entities = query.list();
        return entities;
    }

    @Override
    public UserinfoEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.userInfoId = :id");
        query.setParameter("id", id);
        List<UserinfoEntity> entities = query.list();

        if (entities.size() == 0){
            return null;
        }

        return entities.get(0);
    }

    @Override
    public UserinfoEntity findByPersonId(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.userId = :id");
        query.setParameter("id", id);
        List<UserinfoEntity> entities = query.list();

        if (entities.size() == 0){
            return null;
        }

        return entities.get(0);
    }

    @Override
    public Iterable<UserinfoEntity> findByName(String name) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.name = :name");
        query.setParameter("name", name);
        Iterable<UserinfoEntity> entities = query.list();
        return entities;
    }

    @Override
    public Iterable<UserinfoEntity> findBySurname(String surname) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.surname = :surname");
        query.setParameter("surname", surname);
        Iterable<UserinfoEntity> entities = query.list();
        return entities;
    }

    @Override
    public Iterable<UserinfoEntity> findByPatronymic(String patronymic) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.patronymic = :patronymic");
        query.setParameter("patronymic", patronymic);
        Iterable<UserinfoEntity> entities = query.list();
        return entities;
    }

    @Override
    public Iterable<UserinfoEntity> findByNameAndSurname(String name, String surname) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.name = :name and u.surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        Iterable<UserinfoEntity> entities = query.list();
        return entities;
    }

    @Override
    public Iterable<UserinfoEntity> findByNameAndPatronymic(String name, String patronymic) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.name = :name and u.patronymic = :patronymic");
        query.setParameter("name", name);
        query.setParameter("patronymic", patronymic);
        Iterable<UserinfoEntity> entities = query.list();
        return entities;
    }

    @Override
    public Iterable<UserinfoEntity> findByFullNme(String name, String surname, String patronymic) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from UserinfoEntity u where u.name = :name and u.patronymic = :patronymic and u.surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        query.setParameter("patronymic", patronymic);
        Iterable<UserinfoEntity> entities = query.list();
        return entities;
    }

    @Override
    public void create(UserinfoEntity userEntity) {
        Session session = getCurrentSession();
        session.save(userEntity);
    }

    @Override
    public void update(UserinfoEntity userEntity) {
        Session session = getCurrentSession();
        session.update(userEntity);
    }

    @Override
    public void delete(UserinfoEntity userEntity) {
        Session session = getCurrentSession();
        session.delete(userEntity);
    }

}
