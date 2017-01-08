package com.luxoft.buying_currency.model;

import javax.persistence.*;
import java.util.*;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "history", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Record> records = new LinkedHashSet<Record>();

    public History(User user) {
        this.user = user;
    }

    public History() {
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

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }
}
