package com.bsuir.agency.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Repository
@Transactional
public interface BaseRepository {
    SessionFactory sessionFactory = null;
    void setSessionFactory(SessionFactory sessionFactory);
    SessionFactory getSessionFactory();
}
