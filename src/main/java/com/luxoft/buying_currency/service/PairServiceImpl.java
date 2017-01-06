package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.dao.PairDao;
import com.luxoft.buying_currency.model.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by User on 03.01.2017.
 */
@Service("pairService")
public class PairServiceImpl implements PairService {

    @Autowired
    private PairDao dao;

    @Override
    @Transactional
    public void addPair(Pair pair) {
        dao.add(pair);
    }

    @Override
    public Pair getPair(String name) {
        return dao.get(name);
    }

//    private static final int MIN_COURSE = 1;
//    private static final int MAX_COURSE = 200;
//    private static final int DEVIATION = 60;
//
//    private double newCourse() {
//        Random rnd = new Random(System.currentTimeMillis());
//        return MIN_COURSE + rnd.nextInt(MAX_COURSE - MIN_COURSE + 1);
//    }
}
