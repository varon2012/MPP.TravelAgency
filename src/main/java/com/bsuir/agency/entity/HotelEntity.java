package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "hotel", schema = "travel_agency", catalog = "")
public class HotelEntity {
    private int hotelId;
    private String stars;
    private String name;
    private String address;
    private int representativeId;

    @Id
    @Column(name = "hotel_id", nullable = false)
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        if (hotelId < 1){
            throw new IllegalArgumentException();
        }
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "stars", nullable = false)
    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = false, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "representativeId", nullable = false)
    public int getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(int representativeId) {
        if (representativeId < 1){
            throw new IllegalArgumentException();
        }
        this.representativeId = representativeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelEntity that = (HotelEntity) o;

        if (hotelId != that.hotelId) return false;
        if (representativeId != that.representativeId) return false;
        if (stars != null ? !stars.equals(that.stars) : that.stars != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId;
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + representativeId;
        return result;
    }
}
