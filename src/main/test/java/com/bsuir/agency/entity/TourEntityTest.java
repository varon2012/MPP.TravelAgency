package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class TourEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setUserId_minusId_throwsException(){
        TourEntity tourEntity = new TourEntity();
        tourEntity.setExcursionId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRepresentativeId_minusId_throwsException(){
        TourEntity tourEntity = new TourEntity();
        tourEntity.setRepresentativeId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTourId_minusId_throwsException(){
        TourEntity tourEntity = new TourEntity();
        tourEntity.setTourId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setViews_minusId_throwsException(){
        TourEntity tourEntity = new TourEntity();
        tourEntity.setViews(-1);
    }
}