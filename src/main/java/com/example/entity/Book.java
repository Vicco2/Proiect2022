package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="t_book")
public class Book {

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;

    public Book() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Column(name = "name") //normal ar trebui sa il mapezi ca si la @Entity cu @Column (name = " (variabila din database care iti convine "), dar eu le am identic ca in db deci e ok
    private String Name;
    @Column(name = "year")
    private int Year;
    @Column(name = "writer")
    private String Writer;
    @Column(name = "price")
    private int Price;

    public Book(String Name, int Year, String Writer, int Price) {
        this.Name = Name;
        this.Year = Year;
        this.Price = Price;
        this.Writer = Writer;
    }


}
