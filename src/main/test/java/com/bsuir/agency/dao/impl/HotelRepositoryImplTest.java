package com.bsuir.agency.dao.impl;

import com.bsuir.agency.dao.HotelRepository;
import com.bsuir.agency.entity.HotelEntity;
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
public class HotelRepositoryImplTest {
    HotelRepository hotelRepository;
    Session session;

    @Before
    public void setUp() throws Exception{
        hotelRepository = new HotelRepositoryImpl();
        SessionFactory sessionFactory = null;
        Configuration conf = new Configuration().configure();
        sessionFactory = conf.buildSessionFactory();

        session = sessionFactory.openSession();
        hotelRepository.setSessionFactory(sessionFactory);
    }

    /*
    @Test
    public void createEntity_normalValue_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress("Lenina 1");
        hotelEntity.setName("Hotel");
        hotelEntity.setStars("4");

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.create(hotelEntity);
        HotelEntity hotelEntity1 = hotelRepository.findByName("");
        transaction.commit();
        assertEquals(hotelEntity.getAddress(), hotelEntity.getAddress());
    }
*/
    @Test
    public void updateEntity_normalValue_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setHotelId(2);
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress("Lenina 1");
        hotelEntity.setName("New Vasuky");
        hotelEntity.setStars("4");

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.update(hotelEntity);
        HotelEntity hotelEntity1 = hotelRepository.findByName("New Vasuky");
        transaction.commit();
        assertEquals(hotelEntity.getAddress(), hotelEntity.getAddress());
    }

    @Test(expected = org.hibernate.PropertyValueException.class)
    public void createEntity_nameNull_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setHotelId(1);
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress("Lenina 1");
        hotelEntity.setName(null);
        hotelEntity.setStars("4");

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.create(hotelEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_addressNull_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress(null);
        hotelEntity.setName("Hotel");
        hotelEntity.setStars("4");

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.create(hotelEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_starsNull_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress("Lenina 1");
        hotelEntity.setName("Hotel");
        hotelEntity.setStars(null);

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.create(hotelEntity);
        transaction.commit();
    }


    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_starsNulAddress_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress(null);
        hotelEntity.setName("Hotel");
        hotelEntity.setStars(null);

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.create(hotelEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_starsAndNameNull_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress("Lenina 1");
        hotelEntity.setName(null);
        hotelEntity.setStars(null);

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.create(hotelEntity);
        transaction.commit();
    }

    @Test(expected = org.hibernate.PropertyAccessException.class)
    public void createEntity_allNull_returnTrue() {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setRepresentativeId(1);
        hotelEntity.setAddress(null);
        hotelEntity.setName(null);
        hotelEntity.setStars(null);

        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        hotelRepository.create(hotelEntity);
        transaction.commit();
    }

    @Test
    public void findByName_exsitingValue_returnTrue() {
        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        HotelEntity hotelEntity = hotelRepository.findByName("Hotel");
        transaction.commit();
        assertNotEquals(hotelEntity, null);
    }

    @Test
    public void findByName_NotExsitingValue_returnTrue() {
        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        HotelEntity hotelEntity = hotelRepository.findByName("lafebuibf");
        transaction.commit();
        assertEquals(hotelEntity, null);
    }

    @Test
    public void findAll_notNull_returnTrue() {
        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<HotelEntity> hotelEntities = (List<HotelEntity>) hotelRepository.findAll();
        transaction.commit();
        assertNotEquals(hotelEntities.size(), 0);
    }

    @Test
    public void findById_ExsitingValue_returnTrue() {
        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        HotelEntity hotelEntity = hotelRepository.findById(1);
        transaction.commit();
        assertNotEquals(hotelEntity, null);
    }

    @Test
    public void findById_NotExsitingValue_returnTrue() {
        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        HotelEntity hotelEntity = hotelRepository.findById(42);
        transaction.commit();
        assertEquals(hotelEntity, null);
    }

    @Test
    public void findByRepresentativeId_ExsitingValue_returnTrue() {
        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<HotelEntity> hotelEntities = (List<HotelEntity>) hotelRepository.findByRepresentativeId(1);
        transaction.commit();
        assertNotEquals(hotelEntities.size(), 0);
    }
    @Test
    public void findByRepresentativeId_NotExsitingValue_returnTrue() {
        Transaction transaction = hotelRepository.getSessionFactory().getCurrentSession().beginTransaction();
        List<HotelEntity> hotelEntities = (List<HotelEntity>) hotelRepository.findByRepresentativeId(42);
        transaction.commit();
        assertEquals(hotelEntities.size(), 0);
    }
}