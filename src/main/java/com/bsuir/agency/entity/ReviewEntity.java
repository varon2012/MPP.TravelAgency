package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "review", schema = "travel_agency", catalog = "")
public class ReviewEntity {
    private int reviewId;
    private String text;
    private String mark;
    private int userId;
    private int tourId;

    @Id
    @Column(name = "review_id", nullable = false)
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        if (reviewId < 0){
            throw new IllegalArgumentException();
        }
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "text", nullable = false, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "mark", nullable = false)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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

        ReviewEntity that = (ReviewEntity) o;

        if (reviewId != that.reviewId) return false;
        if (userId != that.userId) return false;
        if (tourId != that.tourId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + tourId;
        return result;
    }
}
