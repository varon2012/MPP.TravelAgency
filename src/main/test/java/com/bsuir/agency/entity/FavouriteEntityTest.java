package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 12.05.2017.
 */
public class FavouriteEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setFavouriteId_minusId_throwsException(){
        FavouriteEntity favouriteEntity = new FavouriteEntity();
        favouriteEntity.setFavouriteId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUserId_minusId_throwsException(){
        FavouriteEntity favouriteEntity = new FavouriteEntity();
        favouriteEntity.setUserId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTourId_minusId_throwsException(){
        FavouriteEntity favouriteEntity = new FavouriteEntity();
        favouriteEntity.setTourId(-1);
    }
}