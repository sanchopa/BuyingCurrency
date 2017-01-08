package com.luxoft.buying_currency.model;

import javax.persistence.*;
import java.text.DecimalFormat;

/**
 * Created by User on 07.01.2017.
 */
@Entity(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recordID;
    @Column
    String buy;
    @Column
    double sumbuy;
    @Column
    String sale;
    @Column
    double sumsale;
    @Column
    double course;
    @ManyToOne
    @JoinColumn(name = "historyid", nullable=false)
    History history;

    public Record(History history, String buy, double sumbuy, String sale, double sumsale, double course) {
        this.history = history;
        this.buy = buy;
        this.sumbuy = sumbuy;
        this.sale = sale;
        this.sumsale = sumsale;
        this.course = course;
    }

    public Record() {
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public long getRecordID() {
        return recordID;
    }

    public void setRecordID(long recordID) {
        this.recordID = recordID;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public double getSumbuy() {
        return sumbuy;
    }

    public void setSumbuy(double sumbuy) {
        this.sumbuy = sumbuy;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public double getSumsale() {
        return sumsale;
    }

    public void setSumsale(double sumsale) {
        this.sumsale = sumsale;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Buy " + buy +
                " sum " + new DecimalFormat("#0.00").format(sumbuy) +
                " sale " + sale +
                " sum " + new DecimalFormat("#0.00").format( sumsale) +
                " course " + new DecimalFormat("#0.00").format(course);
    }


}
