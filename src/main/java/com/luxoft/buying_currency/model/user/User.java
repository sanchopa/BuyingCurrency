package com.luxoft.buying_currency.model.user;

import javax.persistence.*;

/**
 * Created by Alex Zavalnyi on 16.12.2016.
 */

@Entity(name = "users")
public class User {
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    @Column(unique = true)
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
