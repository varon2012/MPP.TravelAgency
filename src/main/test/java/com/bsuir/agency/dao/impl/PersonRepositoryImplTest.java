package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.PersonRepository;
import com.bsuir.agency.entity.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.cfg.Configuration;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
public class PersonRepositoryImplTest{
    PersonRepository personRepository;
    Session session;

    @Before
    public void setUp() throws Exception{
        personRepository = new PersonRepositoryImpl();
        SessionFactory sessionFactory = null;
        Configuration conf = new Configuration().configure();
        sessionFactory = conf.buildSessionFactory();

        session = sessionFactory.openSession();
        personRepository.setSessionFactory(sessionFactory);
    }

    @Test
    public void testMethod() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin("new_login");
        userEntity.setRole("user");
        userEntity.setPhone("12345");
        userEntity.setPasswordHash("23tgnd983g4wv9g");

        SessionFactory sessionFactory = personRepository.getSessionFactory();
        //Session session = sessionFactory.openSession();
        Transaction transaction = personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
        PersonEntity personEntity = personRepository.findByLogin(userEntity.getLogin());
        transaction.commit();
        assertEquals(personEntity.getLogin(), userEntity.getLogin());
        //assertEquals(userEntity.getLogin() == personEntity.getLogin(), true);
    }
}