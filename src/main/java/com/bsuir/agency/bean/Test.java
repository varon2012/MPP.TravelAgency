package com.bsuir.agency.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_table",schema = "test")
public class Test {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Id
    @Column(name = "id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;
}
