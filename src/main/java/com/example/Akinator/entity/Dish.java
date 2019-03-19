package com.example.Akinator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
