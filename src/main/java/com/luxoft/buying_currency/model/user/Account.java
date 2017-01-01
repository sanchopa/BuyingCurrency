package com.luxoft.buying_currency.model.user;

import javax.persistence.*;

/**
 * Класс в котором описано состояние счета клиента
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
@Entity(name = "account")
public class Account {

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @Id
    private long accountID;
    @Column
    private String balanceRUB;
    @Column
    private String balanceUSD;
    @Column
    private String balanceEUR;

    public Account(User user, String balanceRUB, String balanceUSD, String balanceEUR) {
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

    public void setBalanceEUR(String balanceEUR) {
        this.balanceEUR = balanceEUR;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
