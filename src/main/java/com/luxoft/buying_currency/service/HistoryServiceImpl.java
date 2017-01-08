package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.model.History;
import com.luxoft.buying_currency.model.Record;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Alexander Zavalnyi on 08.01.2017.
 */

@Service("historyService")
@Transactional
public class HistoryServiceImpl implements HistoryService {
    private static final Logger log = Logger.getLogger(HistoryServiceImpl.class);

    @Override
    @Transactional
    public void saveHistory(History history, String buy, double sumbuy, String sale, double sumsale, double course) {
        Record record = new Record(history, buy, sumbuy, sale, sumsale, course);
        //history.getRecords().clear();
        history.getRecords().add(record);
    }

    @Override
    @Transactional
    public String getHistory(History history) {
        StringBuilder historystr = new StringBuilder("  ");
        Set<Record> records = history.getRecords();
        if(records!=null){
        for (Record record:records) {
            historystr.append("<p>"+record.toString()+"<p>");
            }
        }
        return  historystr.toString();
    }
}
