package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.RepresentativeRepository;
import com.bsuir.agency.entity.RepresentativeinfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 01.06.2017.
 */
public class RepresentativeRepositoryImplTest {
    RepresentativeRepository representativeRepository;
    Session session;

    @Before
    public void setUp() throws Exception{
        representativeRepository = new RepresentativeRepositoryImpl();
        SessionFactory sessionFactory = null;
        Configuration conf = new Configuration().configure();
        sessionFactory = conf.buildSessionFactory();

        session = sessionFactory.openSession();
        representativeRepository.setSessionFactory(sessionFactory);
    }

    /*
    @Test
    public void createEntity_normalValue_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity("London");
        representativeinfoEntity.setCountry("GB");
        representativeinfoEntity.setOrganizationName("Roga i kopyta");
        representativeinfoEntity.setOrganizationNumber("1244436y4553");

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        RepresentativeinfoEntity representativeinfoEntity1 = representativeRepository.findByOrgNumber("1244436y4553");
        transaction.commit();
        assertEquals(representativeinfoEntity.getOrganizationNumber(), representativeinfoEntity1.getOrganizationNumber());
    }
*/
    @Test
    public void updateEntity_normalValue_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeId(2);
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity("London");
        representativeinfoEntity.setCountry("GB");
        representativeinfoEntity.setOrganizationName("Roga i kopyta2");
        representativeinfoEntity.setOrganizationNumber("1244436y4553");

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.update(representativeinfoEntity);
        RepresentativeinfoEntity representativeinfoEntity1 = representativeRepository.findByOrgNumber("1244436y4553");
        transaction.commit();
        assertEquals(representativeinfoEntity.getOrganizationName(), representativeinfoEntity1.getOrganizationName());
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_cityNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity(null);
        representativeinfoEntity.setCountry("GB");
        representativeinfoEntity.setOrganizationName("Roga i kopyta2");
        representativeinfoEntity.setOrganizationNumber("1244436y4553");

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_CountryNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity("London");
        representativeinfoEntity.setCountry(null);
        representativeinfoEntity.setOrganizationName("Roga i kopyta2");
        representativeinfoEntity.setOrganizationNumber("1244436y4553");

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_OrgNameNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity("London");
        representativeinfoEntity.setCountry("GB");
        representativeinfoEntity.setOrganizationName(null);
        representativeinfoEntity.setOrganizationNumber("1244436y4553");

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_OrgNumberNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity("London");
        representativeinfoEntity.setCountry("GB");
        representativeinfoEntity.setOrganizationName("Roga i kopyta2");
        representativeinfoEntity.setOrganizationNumber(null);

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_OrgNumberOrgNameNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity("London");
        representativeinfoEntity.setCountry("GB");
        representativeinfoEntity.setOrganizationName(null);
        representativeinfoEntity.setOrganizationNumber(null);

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_OrgNumberCountryNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity("London");
        representativeinfoEntity.setCountry(null);
        representativeinfoEntity.setOrganizationName("Roga i kopyta2");
        representativeinfoEntity.setOrganizationNumber(null);

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_OrgNumberCityNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity(null);
        representativeinfoEntity.setCountry("GB");
        representativeinfoEntity.setOrganizationName("Roga i kopyta2");
        representativeinfoEntity.setOrganizationNumber(null);

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }


    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_allNull_returnTrue() {
        RepresentativeinfoEntity representativeinfoEntity = new RepresentativeinfoEntity();
        representativeinfoEntity.setRepresentativeUserId(1);
        representativeinfoEntity.setCity(null);
        representativeinfoEntity.setCountry(null);
        representativeinfoEntity.setOrganizationName(null);
        representativeinfoEntity.setOrganizationNumber(null);

        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        representativeRepository.create(representativeinfoEntity);
        transaction.commit();
    }

    @Test
    public void findByCity_ExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<RepresentativeinfoEntity> representativeinfoEntity = (List<RepresentativeinfoEntity>) representativeRepository.findByCity("Moscow");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByCity_NotExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<RepresentativeinfoEntity> representativeinfoEntity = (List<RepresentativeinfoEntity>) representativeRepository.findByCity("dont know");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByCountry_ExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<RepresentativeinfoEntity> representativeinfoEntity = (List<RepresentativeinfoEntity>) representativeRepository.findByCountry("Russia");
        assertNotEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByCountry_NotExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<RepresentativeinfoEntity> representativeinfoEntity = (List<RepresentativeinfoEntity>) representativeRepository.findByCountry("dont know");
        assertEquals(representativeinfoEntity.size(), 0);
    }

    @Test
    public void findByOrgNumber_ExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        RepresentativeinfoEntity representativeinfoEntity = representativeRepository.findByOrgNumber("1244436y4553");
        assertNotEquals(representativeinfoEntity, null);
    }

    @Test
    public void findByOrgNumber_NotExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        RepresentativeinfoEntity representativeinfoEntity = representativeRepository.findByOrgNumber("rqwfweft4");
        assertEquals(representativeinfoEntity, null);
    }

    @Test
    public void findByOrgName_ExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        RepresentativeinfoEntity representativeinfoEntity = representativeRepository.findByOrgName("Roga i kopyta");
        assertNotEquals(representativeinfoEntity, null);
    }

    @Test
    public void findByOrgName_NotExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        RepresentativeinfoEntity representativeinfoEntity = representativeRepository.findByOrgName("Roga i kopyta21fcev");
        assertEquals(representativeinfoEntity, null);
    }

    @Test
    public void findByRepId_ExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        RepresentativeinfoEntity representativeinfoEntity = representativeRepository.findByPersonId(1);
        assertNotEquals(representativeinfoEntity, null);
    }

    @Test
    public void findByRepId_NotExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        RepresentativeinfoEntity representativeinfoEntity = representativeRepository.findByPersonId(42);
        assertEquals(representativeinfoEntity, null);
    }

    @Test
    public void findAll_ExistingValue_returnTrue() {
        Transaction transaction = representativeRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<RepresentativeinfoEntity> representativeinfoEntity = (List<RepresentativeinfoEntity>) representativeRepository.findAll();
        assertNotEquals(representativeinfoEntity.size(), 0);
    }
}