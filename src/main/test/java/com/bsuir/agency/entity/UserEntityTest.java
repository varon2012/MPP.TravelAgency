package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class UserEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setUserId_minusId_throwsException(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUserInfoId_minusId_throwsException(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserInfoId(-1);
    }
}