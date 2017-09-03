package com.bsuir.agency.entity;

import javax.management.relation.Role;
import javax.persistence.*;

/**
 * Created by Олег Пятко on 13.04.2017.
 */
@Entity
@Table(name = "person", schema = "travel_agency", catalog = "")
public class PersonEntity {
    private int userId;
    private RoleEnum role;
    private String passwordHash;
    private String login;
    private String phone;
    private String email;

    @Id
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
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Basic
    @Column(name = "passwordHash", nullable = false, length = 30)
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (userId != that.userId) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (passwordHash != null ? !passwordHash.equals(that.passwordHash) : that.passwordHash != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
