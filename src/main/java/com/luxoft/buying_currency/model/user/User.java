package com.luxoft.buying_currency.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Alex Zavalnyi on 16.12.2016.
 */

@Entity(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long userID;
    @Column (unique = true)
    private String name;
    @Column
    private String balanceRUB;
    @Column
    private String balanceUSD;
    @Column
    private String balanceEUR;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public String getBalanceRUB() {
        return balanceRUB;
    }

    public void setBalanceRUB(String balanceRUB) {
        this.balanceRUB = balanceRUB;
    }

    public String getBalanceUSD() {
        return balanceUSD;
    }

    public void setBalanceUSD(String balanceUSD) {
        this.balanceUSD = balanceUSD;
    }

    public String getBalanceEUR() {
        return balanceEUR;
    }

    public void setBalanceEUR(String balancrEUR) {
        this.balanceEUR = balancrEUR;
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
}
