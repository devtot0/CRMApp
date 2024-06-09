package com.example.CRMApp.entity;

import jakarta.persistence.Entity;
import org.vaadin.stepbystep.person.backend.AbstractEntity;

//@Entity
public class Status extends AbstractEntity {
    private String name;

    public Status() {

    }

    public Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}