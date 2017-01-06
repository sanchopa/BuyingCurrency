package com.luxoft.buying_currency.model;

import javax.persistence.*;

/**
 * Created by User on 03.01.2017.
 */
@Entity(name = "pair")
public class Pair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column
    private double course;

    public Pair(String name, double course) {
        this.name = name;
        this.course = course;
    }

    public Pair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }
}
