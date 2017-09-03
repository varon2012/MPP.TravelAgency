package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class PhotoEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setPersonId_minusId_throwsException(){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setUserId(-1);
    }
}