package com.bsuir.agency.dao.impl;

import com.bsuir.agency.entity.PersonEntity;
import com.bsuir.agency.entity.RoleEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Олег Пятко on 14.04.2017.
 */
@Repository
@Transactional
public class PersonRepositoryImpl extends BaseRepositoryImpl implements com.bsuir.agency.dao.PersonRepository {
    @Override
    public List<PersonEntity> getAllUsers() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PersonEntity ");
        List<PersonEntity> users = query.list();
        return users;
    }

    @Override
    public PersonEntity findById(int id) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PersonEntity p where p.userId = :id");
        query.setParameter("id", id);
        List<PersonEntity> personEntities = query.list();
        if (personEntities.size() == 0){
            return null;
        }

        return personEntities.get(0);
    }

    @Override
    public PersonEntity findByLogin(String login) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PersonEntity p where p.login = :login");
        query.setParameter("login", login);
        List<PersonEntity> personEntities = query.list();
        if (personEntities.size() == 0){
            return null;
        }

        return personEntities.get(0);
    }

    @Override
    public PersonEntity findByEmail(String email) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PersonEntity p where p.email = :email");
        query.setParameter("email", email);
        List<PersonEntity> personEntities = query.list();
        if (personEntities.size() == 0){
            return null;
        }

        return personEntities.get(0);
    }

    @Override
    public Iterable<PersonEntity> findByRole(RoleEnum role) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from PersonEntity p where p.role = :role");
        query.setParameter("role", role);
        List<PersonEntity> personEntities = query.list();
        return personEntities;
    }

    @Override
    public void create(PersonEntity personEntity) {
        Session session = getCurrentSession();

        session.save(personEntity);
    }

    @Override
    public void update(PersonEntity personEntity) {
        Session session = getCurrentSession();

        session.update(personEntity);
    }

    @Override
    public void delete(PersonEntity personEntity) {
        Session session = getCurrentSession();

        session.delete(personEntity);
    }
}
