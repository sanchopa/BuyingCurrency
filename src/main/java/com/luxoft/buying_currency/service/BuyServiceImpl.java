package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alexandr Zavalnyi on 04.01.2017.
 */
@Service("buyService")
public class BuyServiceImpl implements BuyService {
    private static final Logger log = Logger.getLogger(BuyServiceImpl.class);
    @Autowired
    PairService pairService;
    @Autowired
    UserService userService;
    @Autowired
    HistoryService historyService;

    @Override
    public void buy(int currency1, int currency2, String sum, User user) {
        if (currency1 != currency2) {
            double dsum = Double.parseDouble(sum);
            if (currency1 == 1 && currency2 == 2) {
                log.info("Есть такая пара USD/RUB");
                buyUSDRUB(sum, dsum, user);
            }
            if (currency1 == 3 && currency2 == 1) {
                log.info("Есть такая пара EUR/USD");
                buyEURUSD(sum, dsum, user);
            }
            if (currency1 == 3 && currency2 == 2) {
                log.info("Есть такая пара EUR/RUB");
                buyEURRUB(sum, dsum, user);
            }
            if (currency1 == 2 && currency2 == 1) {
                log.info("Обратная пара от USD/RUB");
                buyRUBUSD(sum, dsum, user);
            }
            if (currency1 == 1 && currency2 == 3) {
                log.info("Обратная пара от EUR/USD");
                buyUSDEUR(sum, dsum, user);
            }
            if (currency1 == 2 && currency2 == 3) {
                log.info("Обратная пара от EUR/RUB");
                buyRUBEUR(sum, dsum, user);
            }
        } else {
            log.info("Выберите РАЗНУЮ валюту");
        }
    }

    private void buyUSDRUB(String sum, double dsum, User user) {
        Account account = user.getAccount();
        double cours = pairService.getPair("usdrub").getCourse();
        double amountSold = dsum * cours;
        double sellCurrency = account.getBalanceUSD();
        double buyCurrency = account.getBalanceRUB();
        if (amountSold <= buyCurrency) {
            account.setBalanceUSD(sellCurrency + dsum);
            account.setBalanceRUB(buyCurrency - amountSold);
            user.setAccount(account);
            historyService.saveHistory(user.getHistory(),"USD",dsum,"RUB", amountSold, cours);
            userService.saveUser(user);
        } else {
            log.info("Сумма " + sum + " больше баланса " + buyCurrency);
        }
    }

    private void buyRUBUSD(String sum, double dsum, User user) {
        Account account = user.getAccount();
        double cours = 1 / pairService.getPair("usdrub").getCourse();
        double amountSold = dsum * cours;
        double sellCurrency = account.getBalanceRUB();
        double buyCurrency = account.getBalanceUSD();
        if (amountSold <= buyCurrency) {
            account.setBalanceRUB(sellCurrency + dsum);
            account.setBalanceUSD(buyCurrency - amountSold);
            user.setAccount(account);
            historyService.saveHistory(user.getHistory(),"RUB",dsum,"USD", amountSold, cours);
            userService.saveUser(user);
        } else {
            log.info("Сумма " + sum + " больше баланса " + buyCurrency);
        }
    }

    private void buyEURUSD(String sum, double dsum, User user) {
        Account account = user.getAccount();
        double cours = pairService.getPair("eurusd").getCourse();
        double amountSold = dsum * cours;
        double sellCurrency = account.getBalanceEUR();
        double buyCurrency = account.getBalanceUSD();
        if (amountSold <= buyCurrency) {
            account.setBalanceEUR(sellCurrency + dsum);
            account.setBalanceUSD(buyCurrency - amountSold);
            user.setAccount(account);
            historyService.saveHistory(user.getHistory(),"EUR",dsum,"USD", amountSold, cours);
            userService.saveUser(user);
        } else {
            log.info("Сумма " + sum + " больше баланса " + buyCurrency);
        }
    }

    private void buyUSDEUR(String sum, double dsum, User user) {
        Account account = user.getAccount();
        double cours = 1 / pairService.getPair("eurusd").getCourse();
        double amountSold = dsum * cours;
        double sellCurrency = account.getBalanceUSD();
        double buyCurrency = account.getBalanceEUR();
        if (amountSold <= buyCurrency) {
            account.setBalanceUSD(sellCurrency + dsum);
            account.setBalanceEUR(buyCurrency - amountSold);
            user.setAccount(account);
            historyService.saveHistory(user.getHistory(),"USD",dsum,"EUR", amountSold, cours);
            userService.saveUser(user);
        } else {
            log.info("Сумма " + sum + " больше баланса " + buyCurrency);
        }
    }

    private void buyEURRUB(String sum, double dsum, User user) {
        Account account = user.getAccount();
        double cours = pairService.getPair("eurrub").getCourse();
        double amountSold = dsum * cours;
        double sellCurrency = account.getBalanceEUR();
        double buyCurrency = account.getBalanceRUB();
        if (amountSold <= buyCurrency) {
            account.setBalanceEUR(sellCurrency + dsum);
            account.setBalanceRUB(buyCurrency - amountSold);
            user.setAccount(account);
            historyService.saveHistory(user.getHistory(),"EUR",dsum,"RUB", amountSold, cours);
            userService.saveUser(user);
        } else {
            log.info("Сумма " + sum + " больше баланса " + buyCurrency);
        }
    }

    private void buyRUBEUR(String sum, double dsum, User user) {
        Account account = user.getAccount();
        double cours = 1 / pairService.getPair("eurrub").getCourse();
        double amountSold = dsum * cours;
        double sellCurrency = account.getBalanceRUB();
        double buyCurrency = account.getBalanceEUR();
        if (amountSold <= buyCurrency) {
            account.setBalanceRUB(sellCurrency + dsum);
            account.setBalanceEUR(buyCurrency - amountSold);
            user.setAccount(account);
            historyService.saveHistory(user.getHistory(),"RUB",dsum,"EUR", amountSold, cours);
            userService.saveUser(user);
        } else {
            log.info("Сумма " + sum + " больше баланса " + buyCurrency);
        }
    }
}
