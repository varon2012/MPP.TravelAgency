package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 11.05.2017.
 */
@Entity
@Table(name = "representativeinfo", schema = "travel_agency", catalog = "")
public class RepresentativeEntity {
    private int representativeUserId;
    private int representativeId;

    @Basic
    @Column(name = "representative_user_id", nullable = false)
    public int getRepresentativeUserId() {
        return representativeUserId;
    }

    public void setRepresentativeUserId(int representativeUserId) {
        if (representativeUserId < 1){
            throw new IllegalArgumentException();
        }
        this.representativeUserId = representativeUserId;
    }

    @Id
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

        RepresentativeEntity that = (RepresentativeEntity) o;

        if (representativeUserId != that.representativeUserId) return false;
        if (representativeId != that.representativeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = representativeUserId;
        result = 31 * result + representativeId;
        return result;
    }
}
