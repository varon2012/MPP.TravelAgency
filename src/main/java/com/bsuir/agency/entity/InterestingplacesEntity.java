package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "interestingplaces", schema = "travel_agency", catalog = "")
public class InterestingplacesEntity {
    private int interestingPlaceId;
    private String description;
    private int excursionId;

    @Id
    @Column(name = "interesting_place_id", nullable = false)
    public int getInterestingPlaceId() {
        return interestingPlaceId;
    }

    public void setInterestingPlaceId(int interestingPlaceId) {
        if (interestingPlaceId < 0){
            throw new IllegalArgumentException();
        }
        this.interestingPlaceId = interestingPlaceId;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "excursion_id", nullable = false)
    public int getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(int excursionId) {
        if (excursionId < 0){
            throw new IllegalArgumentException();
        }
        this.excursionId = excursionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterestingplacesEntity that = (InterestingplacesEntity) o;

        if (interestingPlaceId != that.interestingPlaceId) return false;
        if (excursionId != that.excursionId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = interestingPlaceId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + excursionId;
        return result;
    }
}
