package com.luxoft.buying_currency.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr Zavalnyi on 07.01.2017.
 */
@Entity(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long historyID;
    @OneToOne
    User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "history")
    private List<Record> records = new ArrayList<Record>();

    public History(User user) {
        this.user = user;
    }

    public History() {
    }

    public History(User user, List<Record> records) {
        this.user = user;
        this.records = records;
    }

    public long getHistoryID() {
        return historyID;
    }

    public void setHistoryID(long id) {
        this.historyID = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
