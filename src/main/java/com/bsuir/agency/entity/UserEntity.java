package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Entity
@Table(name = "userinfo", schema = "travel_agency", catalog = "")
public class UserEntity {
    private int userId;
    private int userInfoId;

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

    @Id
    @Column(name = "userInfoId", nullable = false)
    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        if (userInfoId < 0){
            throw new IllegalArgumentException();
        }
        this.userInfoId = userInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (userInfoId != that.userInfoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + userInfoId;
        return result;
    }
}
