package com.bsuir.agency.service;


import com.bsuir.agency.bean.Test;
import com.bsuir.agency.dao.ITestDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements IService{


    @Override
    public Test getTest(){
        return iTestDao.getTest();
    }

    @Override
    public List<Test> getTests() {
        return iTestDao.getTests();
    }

    @Autowired
    public void setiTestDao(ITestDao iTestDao) {
        this.iTestDao = iTestDao;
    }

    private ITestDao iTestDao;

}
