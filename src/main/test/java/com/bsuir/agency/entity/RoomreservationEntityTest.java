package com.bsuir.agency.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Олег Пятко on 19.05.2017.
 */
public class RoomreservationEntityTest {
    @Test(expected = IllegalArgumentException.class)
    public void setRoomId_minusId_throwsException(){
        RoomreservationEntity roomreservationEntity = new RoomreservationEntity();
        roomreservationEntity.setRoomId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRoomReservationId_minusId_throwsException(){
        RoomreservationEntity roomreservationEntity = new RoomreservationEntity();
        roomreservationEntity.setRoomReservationId(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUserId_minusId_throwsException(){
        RoomreservationEntity roomreservationEntity = new RoomreservationEntity();
        roomreservationEntity.setUserId(-1);
    }
}