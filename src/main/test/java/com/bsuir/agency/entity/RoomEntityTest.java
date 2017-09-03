package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class RoomEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setHotelId_minusId_throwsException(){
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setHotelId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRoomId_minusId_throwsException(){
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRoomNumber_minusId_throwsException(){
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomNumber(-1);
    }
}