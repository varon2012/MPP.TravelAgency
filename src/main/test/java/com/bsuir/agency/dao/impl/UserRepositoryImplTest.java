package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.UserRepository;
import com.bsuir.agency.entity.UserEntity;
import com.bsuir.agency.entity.UserinfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
//import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 01.06.2017.
 */
public class UserRepositoryImplTest {
    UserRepository userRepository;
    Session session;

    @Before
    public void setUp() throws Exception{
        userRepository = new UserRepositoryImpl();
        SessionFactory sessionFactory = null;
        Configuration conf = new Configuration().configure();
        sessionFactory = conf.buildSessionFactory();

        session = sessionFactory.openSession();
        userRepository.setSessionFactory(sessionFactory);
    }

    @Test
    public void createEntity_normalValue_returnTrue() {
        UserinfoEntity userEntity = new UserinfoEntity();
        userEntity.setName("Oleg");
        userEntity.setSurname("Pyatko");
        userEntity.setPatronymic("Svyatoslavovich");
        userEntity.setUserId(1);

        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        userRepository.create(userEntity);
       // UserinfoEntity userinfoEntity = userRepository.findByFullNme("Oleg", "Pyatko", "Svyatoslavovich");
        transaction.commit();
        //assertEquals(representativeinfoEntity.getOrganizationNumber(), representativeinfoEntity1.getOrganizationNumber());
    }

    @Test
    public void updateEntity_normalValue_returnTrue() {
        UserinfoEntity userEntity = new UserinfoEntity();
        userEntity.setUserId(1);
        userEntity.setUserInfoId(1);
        userEntity.setName("Oleg");
        userEntity.setSurname("Pyatko");
        userEntity.setPatronymic("Updated");
        userEntity.setUserInfoId(1);

        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        userRepository.update(userEntity);
        // UserinfoEntity userinfoEntity = userRepository.findByFullNme("Oleg", "Pyatko", "Svyatoslavovich");
        transaction.commit();
        //assertEquals(representativeinfoEntity.getOrganizationNumber(), representativeinfoEntity1.getOrganizationNumber());
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void createEntity_NameNull_returnTrue() {
        UserinfoEntity userEntity = new UserinfoEntity();
        userEntity.setUserId(1);
        userEntity.setUserInfoId(1);
        userEntity.setName(null);
        userEntity.setSurname("Pyatko");
        userEntity.setPatronymic("Updated");
        userEntity.setUserInfoId(1);

        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        userRepository.update(userEntity);
        transaction.commit();
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void createEntity_SurnameNull_returnTrue() {
        UserinfoEntity userEntity = new UserinfoEntity();
        userEntity.setUserId(1);
        userEntity.setUserInfoId(1);
        userEntity.setName("Oleg");
        userEntity.setSurname(null);
        userEntity.setPatronymic("Updated");
        userEntity.setUserInfoId(1);

        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        userRepository.update(userEntity);
        transaction.commit();
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void createEntity_PatronymicNull_returnTrue() {
        UserinfoEntity userEntity = new UserinfoEntity();
        userEntity.setUserId(1);
        userEntity.setUserInfoId(1);
        userEntity.setName("Oleg");
        userEntity.setSurname("Pyatko");
        userEntity.setPatronymic(null);
        userEntity.setUserInfoId(1);

        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        userRepository.update(userEntity);
        transaction.commit();
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void createEntity_NameSurnameNull_returnTrue() {
        UserinfoEntity userEntity = new UserinfoEntity();
        userEntity.setUserId(1);
        userEntity.setUserInfoId(1);
        userEntity.setName(null);
        userEntity.setSurname(null);
        userEntity.setPatronymic("Updated");
        userEntity.setUserInfoId(1);

        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        userRepository.update(userEntity);
        transaction.commit();
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void createEntity_NamePatronymicNull_returnTrue() {
        UserinfoEntity userEntity = new UserinfoEntity();
        userEntity.setUserId(1);
        userEntity.setUserInfoId(1);
        userEntity.setName(null);
        userEntity.setSurname("Pyatko");
        userEntity.setPatronymic(null);
        userEntity.setUserInfoId(1);

        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        userRepository.update(userEntity);
        transaction.commit();
    }

    @Test
    public void findByName_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByName("Oleg");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByName_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByName("rsytyjhe");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findBySurname_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findBySurname("Pyatko");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findBySurname_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByName("sdfsv");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByPatronymic_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByPatronymic("Updated");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByPatronymic_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByPatronymic("sdfsfdfv");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByNameAndSurname_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByNameAndSurname("Oleg", "Pyatko");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByNameAndSurname_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByNameAndSurname("sdfsfdfv", "gdsgdfg");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByNameAndPatronymic_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByNameAndPatronymic("Oleg", "Updated");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByNameAndPatronymic_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByNameAndPatronymic("sdfsfdfv", "gdsgdfg");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByFullName_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByFullNme("Oleg","Pyatko", "Updated");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByFullName_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findByFullNme("sdfsfdfv", "sdgsdgsdg", "gdsgdfg");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findAll_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<UserinfoEntity> representativeinfoEntity = (List<UserinfoEntity>) userRepository.findAll();
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findById_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        UserinfoEntity representativeinfoEntity = userRepository.findById(1);
        assertNotEquals(representativeinfoEntity, null);
    }

    @Test
    public void findById_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        UserinfoEntity representativeinfoEntity = userRepository.findById(42);
        assertEquals(representativeinfoEntity, null);
    }

    @Test
    public void findByPersonId_ExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        UserinfoEntity representativeinfoEntity = userRepository.findByPersonId(1);
        assertNotEquals(representativeinfoEntity, null);
    }

    @Test
    public void findByPersonId_NotExistingValue_returnTrue() {
        Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
        UserinfoEntity representativeinfoEntity = userRepository.findByPersonId(42);
        assertEquals(representativeinfoEntity, null);
    }

    @Test
    public void newTest()
    {
       Transaction transaction = userRepository.getSessionFactory().getCurrentSession().beginTransaction();
       UserinfoEntity info = userRepository.findById(-3);
       assertEquals(info, null);

    }
}