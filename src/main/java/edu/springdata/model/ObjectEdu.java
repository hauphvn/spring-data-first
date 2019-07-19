package edu.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ObjectEdu {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectEdu() {
    }

    public ObjectEdu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectEdu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : "  + id;
    }
}
