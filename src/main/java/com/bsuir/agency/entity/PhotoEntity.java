package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "photo", schema = "travel_agency", catalog = "")
public class PhotoEntity {
    private int photoId;
    private String url;
    private Integer roomId;
    private Integer interestingPlaceId;
    private Integer userId;

    @Id
    @Column(name = "photo_id", nullable = false)
    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        if (photoId < 0){
            throw new IllegalArgumentException();
        }
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "url", nullable = false, length = -1)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "room_id", nullable = true)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        if (roomId < 0){
            throw new IllegalArgumentException();
        }
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "interesting_place_id", nullable = true)
    public Integer getInterestingPlaceId() {
        return interestingPlaceId;
    }

    public void setInterestingPlaceId(Integer interestingPlaceId) {
        this.interestingPlaceId = interestingPlaceId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        if (userId < 0){
            throw new IllegalArgumentException();
        }
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoEntity that = (PhotoEntity) o;

        if (photoId != that.photoId) return false;
        if (userId != that.userId) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (interestingPlaceId != null ? !interestingPlaceId.equals(that.interestingPlaceId) : that.interestingPlaceId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = photoId;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (interestingPlaceId != null ? interestingPlaceId.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
