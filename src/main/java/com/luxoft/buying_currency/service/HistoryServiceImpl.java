package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.History;
import com.luxoft.buying_currency.model.Record;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 08.01.2017.
 */

@Service("historyService")
public class HistoryServiceImpl implements HistoryService {
    @Override
    @Transactional
    public void saveHistory(History history, String buy, double sumbuy, String sale, double sumsale, double course) {
        Record record = new Record(history, buy, sumbuy, sale, sumsale, course);
        history.getRecords().clear();
        history.getRecords().add(record);
    }

    @Override
    public ArrayList<String> getHistory(History history) {
        return  null;
    }


}
