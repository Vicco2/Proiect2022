package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_biblioteci")
public class Biblioteci {


        @Id
        @GeneratedValue
        private int id;

    public Biblioteci() {

    }

    public String getNumeBiblioteca() {
        return numeBiblioteca;
    }

    public void setNumeBiblioteca(String numeBiblioteca) {
        this.numeBiblioteca = numeBiblioteca;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    private String numeBiblioteca;
    private String loc;

    public Biblioteci(String NumeBiblioteca,String Locatie) {
        this.numeBiblioteca = NumeBiblioteca;
        this.loc = Locatie;

    }





}
