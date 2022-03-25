package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="t_library")
public class Library {


        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private int id;

    public Library() {

    }

    public String getNameLibrary() {
        return nameLibrary;
    }

    public void setNameLibrary(String nameLibrary) {
        this.nameLibrary = nameLibrary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "name_library")
    private String nameLibrary;
    @Column(name = "location")
    private String location;

    public Library(String nameLibrary, String Locatie) {
        this.nameLibrary = nameLibrary;
        this.location = Locatie;

    }





}
