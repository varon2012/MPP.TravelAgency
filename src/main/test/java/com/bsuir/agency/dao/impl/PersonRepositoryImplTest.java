package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.PersonRepository;
import com.bsuir.agency.entity.PersonEntity;
import com.bsuir.agency.entity.RoleEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.cfg.Configuration;

import java.util.List;

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
    public void createEntity_normalValue_returnTrue() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin("new_login");
        userEntity.setRole(RoleEnum.user);
        userEntity.setPhone("12345");
        userEntity.setPasswordHash("23tgnd983g4wv9g");
        userEntity.setEmail("newemai@fff.fff");

        SessionFactory sessionFactory = personRepository.getSessionFactory();
        //Session session = sessionFactory.openSession();
        Transaction transaction = personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
        PersonEntity personEntity = personRepository.findByLogin(userEntity.getLogin());
        transaction.commit();
        assertEquals(personEntity.getLogin(), userEntity.getLogin());
    }

    @Test
    public void updateEntity_normalValue_returnTrue() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setUserId(22);
        userEntity.setLogin("updated_login");
        userEntity.setRole(RoleEnum.user);
        userEntity.setPhone("1234555111");
        userEntity.setPasswordHash("23tgnd983g4wv9g");
        userEntity.setEmail("newemai@fff.fff");
        Transaction transaction = personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.update(userEntity);
        PersonEntity personEntity = personRepository.findByLogin(userEntity.getLogin());
        transaction.commit();
        assertEquals(personEntity.getLogin(), userEntity.getLogin());
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullRole_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin("new_login1");
        userEntity.setRole(null);
        userEntity.setPhone("12345");
        userEntity.setPasswordHash("23tgnd983g4wv9g");
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullPhone_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin("new_login1");
        userEntity.setRole(RoleEnum.user);
        userEntity.setPhone(null);
        userEntity.setPasswordHash("23tgnd983g4wv9g");
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullPass_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin("new_login1");
        userEntity.setRole(RoleEnum.user);
        userEntity.setPhone("1235643");
        userEntity.setPasswordHash(null);
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullLogin_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin(null);
        userEntity.setRole(RoleEnum.user);
        userEntity.setPhone("1235643");
        userEntity.setPasswordHash("fsdfhdfshfs");
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullLoginAndRole_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin(null);
        userEntity.setRole(null);
        userEntity.setPhone("1235643");
        userEntity.setPasswordHash("fsdfhdfshfs");
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullLoginAndPhone_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin(null);
        userEntity.setRole(RoleEnum.user);
        userEntity.setPhone(null);
        userEntity.setPasswordHash("fsdfhdfshfs");
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullLoginAndPass_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin(null);
        userEntity.setRole(RoleEnum.user);
        userEntity.setPhone("1235643");
        userEntity.setPasswordHash(null);
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullLoginAndRoleAndPhone_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin(null);
        userEntity.setRole(null);
        userEntity.setPhone(null);
        userEntity.setPasswordHash("fsdfhdfshfs");
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullLoginAndRoleAndPass_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin(null);
        userEntity.setRole(null);
        userEntity.setPhone("1235643");
        userEntity.setPasswordHash(null);
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nullAll_throwException() {
        PersonEntity userEntity = new PersonEntity();
        userEntity.setLogin(null);
        userEntity.setRole(null);
        userEntity.setPhone(null);
        userEntity.setPasswordHash(null);
        userEntity.setEmail("newemai@fff.fff");

        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        personRepository.create(userEntity);
    }

    @Test
    public void findByLogin_ExistingValue_returnTrue() {
        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        PersonEntity userEntity = personRepository.findByLogin("admin");
        assertNotEquals(userEntity, null);
    }

    @Test
    public void findByLogin_NotExistingValue_returnTrue() {
        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        PersonEntity userEntity = personRepository.findByLogin("not_exist");
        assertEquals(userEntity, null);
    }

    @Test
    public void findByEmail_ExistingValue_returnTrue() {
        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        PersonEntity userEntity = personRepository.findByEmail("admin@info.by");
        assertNotEquals(userEntity, null);
    }

    @Test
    public void findByEmail_NotExistingValue_returnTrue() {
        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        PersonEntity userEntity = personRepository.findByEmail("lalala");
        assertEquals(userEntity, null);
    }

    @Test
    public void findByRole_ExistingMoreThan1Admin_returnTrue() {
        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<PersonEntity> userEntity = (List<PersonEntity>) personRepository.findByRole(RoleEnum.admin);
        assertNotEquals(userEntity.size(), 0);
    }

    @Test
    public void findById_NotExistingValue_returnTrue() {
        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        PersonEntity userEntity = personRepository.findById(1);
        assertNotEquals(userEntity, null);
    }

    @Test
    public void findAll_NotNull_returnTrue() {
        personRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<PersonEntity> userEntity = (List<PersonEntity>) personRepository.getAllUsers();
        assertNotEquals(userEntity.size(), 0);
    }
}
