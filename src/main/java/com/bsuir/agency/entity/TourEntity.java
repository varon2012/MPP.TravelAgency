package com.bsuir.agency.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "tour", schema = "travel_agency", catalog = "")
public class TourEntity {
    private int tourId;
    private int views;
    private Timestamp fromDate;
    private Timestamp toDateTime;
    private int representativeId;
    private int excursionId;

    @Id
    @Column(name = "tour_id")
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    @Basic
    @Column(name = "views")
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Basic
    @Column(name = "fromDate")
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "toDateTime")
    public Timestamp getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(Timestamp toDateTime) {
        this.toDateTime = toDateTime;
    }

    @Basic
    @Column(name = "representative_id")
    public int getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(int representativeId) {
        this.representativeId = representativeId;
    }

    @Basic
    @Column(name = "excursion_id")
    public int getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(int excursionId) {
        this.excursionId = excursionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourEntity that = (TourEntity) o;

        if (tourId != that.tourId) return false;
        if (views != that.views) return false;
        if (representativeId != that.representativeId) return false;
        if (excursionId != that.excursionId) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (toDateTime != null ? !toDateTime.equals(that.toDateTime) : that.toDateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourId;
        result = 31 * result + views;
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDateTime != null ? toDateTime.hashCode() : 0);
        result = 31 * result + representativeId;
        result = 31 * result + excursionId;
        return result;
    }
}
