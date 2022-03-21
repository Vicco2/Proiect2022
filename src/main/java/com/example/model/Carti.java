package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="t_carte")
public class Carti {

    @Id
    @GeneratedValue
    private int id;

    public Carti() {

    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public int getAn() {
        return An;
    }

    public void setAn(int an) {
        An = an;
    }

    public String getScriitor() {
        return Scriitor;
    }

    public void setScriitor(String scriitor) {
        Scriitor = scriitor;
    }

    public int getPret() {
        return Pret;
    }

    public void setPret(int pret) {
        Pret = pret;
    }

    @Column //normal ar trebui sa il mapezi ca si la @Entity cu @Column (name = " (variabila din database care iti convine "), dar eu le am identic ca in db deci e ok
    private String Nume;
    @Column
    private int An;
    @Column
    private String Scriitor;
    @Column
    private int Pret;

    public Carti(String Nume, int An,String Scriitor, int Pret) {
        this.Nume = Nume;
        this.An = An;
        this.Pret = Pret;
        this.Scriitor = Scriitor;
    }


}
