package com.bsuir.agency.dao;


import com.bsuir.agency.bean.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TestDao implements ITestDao {

    @Override
    public Test getTest() {

        Session session = sessionFactory.getCurrentSession();
        Test test = session.get(Test.class, 1);
        return test;
    }

    @Override
    public List<Test> getTests() {
        Session session = sessionFactory.getCurrentSession();
        List<Test> users = session.createCriteria(Test.class).list();
        return users;
    }


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
