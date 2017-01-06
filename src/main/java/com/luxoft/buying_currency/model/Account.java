package com.luxoft.buying_currency.model;

import javax.persistence.*;

/**
 * Класс в котором описано состояние счета клиента
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
@Entity(name = "account")
public class Account {

    @Id
    private long accountID;
    @Column
    private double balanceRUB;
    @Column
    private double balanceUSD;
    @Column
    private double balanceEUR;
    @OneToOne
    private User user;

    public Account(User user, double balanceRUB, double balanceUSD, double balanceEUR) {
        this.user = user;
        this.balanceRUB = balanceRUB;
        this.balanceUSD = balanceUSD;
        this.balanceEUR = balanceEUR;
    }

    public Account() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalanceRUB() {
        return balanceRUB;
    }

    public void setBalanceRUB(double balanceRUB) {
        this.balanceRUB = balanceRUB;
    }

    public double getBalanceUSD() {
        return balanceUSD;
    }

    public void setBalanceUSD(double balanceUSD) {
        this.balanceUSD = balanceUSD;
    }

    public double getBalanceEUR() {
        return balanceEUR;
    }

    public void setBalanceEUR(double balanceEUR) {
        this.balanceEUR = balanceEUR;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
