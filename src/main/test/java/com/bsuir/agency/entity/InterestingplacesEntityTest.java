package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class InterestingplacesEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setInterestingPlaceId_minusId_throwsIllegalArgumentException(){
        InterestingplacesEntity interestingplacesEntity = new InterestingplacesEntity();
        interestingplacesEntity.setInterestingPlaceId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setExcursionId_minusId_throwsIllegalArgumentException(){
        InterestingplacesEntity interestingplacesEntity = new InterestingplacesEntity();
        interestingplacesEntity.setExcursionId(-1);
    }
}