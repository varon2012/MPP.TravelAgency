package com.bsuir.agency.dao;


import com.bsuir.agency.bean.Test;

import java.util.List;

public interface ITestDao {

    Test getTest();
    List<Test> getTests();
}
