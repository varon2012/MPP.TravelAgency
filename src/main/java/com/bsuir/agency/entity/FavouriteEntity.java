package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "favourite", schema = "travel_agency", catalog = "")
public class FavouriteEntity {
    private int favouriteId;
    private int userId;
    private int tourId;

    @Id
    @Column(name = "favourite_id", nullable = false)
    public int getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(int favouriteId) {
        if (favouriteId < 0){
            throw new IllegalArgumentException();
        }
        this.favouriteId = favouriteId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId < 0){
            throw new IllegalArgumentException();
        }
        this.userId = userId;
    }

    @Basic
    @Column(name = "tour_id", nullable = false)
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        if (tourId < 0){
            throw new IllegalArgumentException();
        }
        this.tourId = tourId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavouriteEntity that = (FavouriteEntity) o;

        if (favouriteId != that.favouriteId) return false;
        if (userId != that.userId) return false;
        if (tourId != that.tourId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = favouriteId;
        result = 31 * result + userId;
        result = 31 * result + tourId;
        return result;
    }
}
