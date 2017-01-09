package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alexandr Zavalnyi on 04.01.2017.
 */
@Service("buyService")
@Transactional
public class BuyServiceImpl implements BuyService {
    private static final Logger log = Logger.getLogger(BuyServiceImpl.class);
    @Autowired
    PairService pairService;
    @Autowired
    UserService userService;
    @Autowired
    HistoryService historyService;

    @Override
    public String buy(String currency1, String currency2, String sum, User user) {
        if (!(currency1.equals(currency2))) {
            double dsum = Double.parseDouble(sum);
            Account account = user.getAccount();
            double cours = pairService.getPair(currency1 + currency2).getCourse();
            double amountSold = dsum * cours;
            double sellCurrency = getBalanceCurrency(account, currency1);
            double buyCurrency = getBalanceCurrency(account, currency2);
            if (amountSold <= buyCurrency) {
                setBalanceCurrency(account, currency1, sellCurrency + dsum);
                setBalanceCurrency(account, currency1, buyCurrency - amountSold);
                user.setAccount(account);
                historyService.saveHistory(user.getHistory(), currency1, dsum, currency2, amountSold, cours);
                userService.saveUser(user);
                return "OK";
            } else {
                return  "Сумма " + sum + " больше баланса " + buyCurrency;
            }
        } else {
            return "Выберите РАЗНУЮ валюту";
        }
    }

    private double getBalanceCurrency(Account account, String currency) {
        if (currency.equals("usd")) {
            return account.getBalanceUSD();
        }
        if (currency.equals("rub")) {
            return account.getBalanceRUB();
        }
        if (currency.equals("eur")) {
            return account.getBalanceEUR();
        }
        return 0;
    }

    private void setBalanceCurrency(Account account, String currency, double balance) {
        if (currency.equals("usd")) {
            account.setBalanceUSD(balance);
        }
        if (currency.equals("rub")) {
            account.setBalanceRUB(balance);
        }
        if (currency.equals("eur")) {
            account.setBalanceEUR(balance);
        }
    }
}
