package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class ReviewEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setReviewId_minusId_throwsException(){
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReviewId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTourId_minusId_throwsException(){
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setTourId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUserId_minusId_throwsException(){
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setUserId(-1);
    }
}