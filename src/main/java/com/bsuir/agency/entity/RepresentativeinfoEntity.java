package com.bsuir.agency.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "representativeinfo", schema = "travel_agency", catalog = "")
public class RepresentativeinfoEntity {
    private int representativeUserId;
    private String organizationNumber;
    private String city;
    private String country;
    private String organizationName;

    @Id
    @Column(name = "representative_user_id")
    public int getRepresentativeUserId() {
        return representativeUserId;
    }

    public void setRepresentativeUserId(int representativeUserId) {
        this.representativeUserId = representativeUserId;
    }

    @Basic
    @Column(name = "organizationNumber")
    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "organizationName")
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepresentativeinfoEntity that = (RepresentativeinfoEntity) o;

        if (representativeUserId != that.representativeUserId) return false;
        if (organizationNumber != null ? !organizationNumber.equals(that.organizationNumber) : that.organizationNumber != null)
            return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (organizationName != null ? !organizationName.equals(that.organizationName) : that.organizationName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = representativeUserId;
        result = 31 * result + (organizationNumber != null ? organizationNumber.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (organizationName != null ? organizationName.hashCode() : 0);
        return result;
    }
}
