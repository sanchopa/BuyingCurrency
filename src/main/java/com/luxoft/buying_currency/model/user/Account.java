package com.luxoft.buying_currency.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

/** Класс в котором описано состояние счета клиента
 * @autor Zavalny Alexander
 * @version 1.0
 */
@Entity(name="account")
public class Account {
    @Id
    private long accountID;

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
