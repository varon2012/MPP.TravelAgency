package com.bsuir.agency.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "room", schema = "travel_agency", catalog = "")
public class RoomEntity {
    private int roomId;
    private BigDecimal price;
    private int roomNumber;
    private int hotelId;

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "roomNumber")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "hotel_id")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (roomId != that.roomId) return false;
        if (roomNumber != that.roomNumber) return false;
        if (hotelId != that.hotelId) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + roomNumber;
        result = 31 * result + hotelId;
        return result;
    }
}
