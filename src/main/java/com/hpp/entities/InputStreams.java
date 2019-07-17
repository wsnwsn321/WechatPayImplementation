package com.hpp.entities;

import javax.persistence.*;

@Entity
@Table(name = "inputstream")
public class InputStreams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "string")
    private String string;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }



}
