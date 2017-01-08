package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.History;

import java.util.ArrayList;

/**
 * Created by User on 08.01.2017.
 */
public interface HistoryService {
    void saveHistory(History history, String buy, double sumbuy,String sale, double sumsale, double course);
    ArrayList<String> getHistory(History history);
}
