package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class HotelEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setHotelId_minusId_throwsIllegalArgumentException(){
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setHotelId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRepresentativeId_minusId_throwsIllegalArgumentException(){
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setRepresentativeId(-1);
    }
}