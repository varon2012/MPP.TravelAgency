package com.bsuir.agency.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "roomreservation", schema = "travel_agency", catalog = "")
public class RoomreservationEntity {
    private int roomReservationId;
    private Date fromDate;
    private Date toDateTime;
    private int roomId;
    private int userId;

    @Id
    @Column(name = "room_reservation_id")
    public int getRoomReservationId() {
        return roomReservationId;
    }

    public void setRoomReservationId(int roomReservationId) {
        this.roomReservationId = roomReservationId;
    }

    @Basic
    @Column(name = "fromDate")
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "toDateTime")
    public Date getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(Date toDateTime) {
        this.toDateTime = toDateTime;
    }

    @Basic
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomreservationEntity that = (RoomreservationEntity) o;

        if (roomReservationId != that.roomReservationId) return false;
        if (roomId != that.roomId) return false;
        if (userId != that.userId) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (toDateTime != null ? !toDateTime.equals(that.toDateTime) : that.toDateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomReservationId;
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDateTime != null ? toDateTime.hashCode() : 0);
        result = 31 * result + roomId;
        result = 31 * result + userId;
        return result;
    }
}
