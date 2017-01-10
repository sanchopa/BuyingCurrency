package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.dao.PairDao;
import com.luxoft.buying_currency.model.Pair;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.TransactionManager;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Alexandr Zavalnyi on 03.01.2017.
 */
@Service("pairService")
public class PairServiceImpl implements PairService {
    private static final Logger log = Logger.getLogger(PairServiceImpl.class);

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

    @Override
    @Transactional
    public void savePair(Pair pair) {
        dao.save(pair);
    }

    @Override
    public double generateRandomDecimal() {
        int rnd = new Random(System.currentTimeMillis()).nextInt(5000 - 100) + 100;
        return rnd / 100;
    }

    @Override
    public void generateRandomCursePair(String namePair) {
        Random random = new Random(System.currentTimeMillis());
        double course = (random.nextInt(5000 - 100) + 100) / 100;

        Pair isPair = getPair(namePair);
        if (isPair == null) {
            addPair(new Pair(namePair, course));
        } else {
            isPair.setCourse(course);
            savePair(isPair);
        }
    }

    @Override
    public void generateRandomPair(int millisecond) {
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            public void run() {
                generateRandomCursePair("usdrub");
                generateRandomCursePair("eurrub");
                generateRandomCursePair("eurusd");
                log.info("Сгенерированны новые курсы");
            }
        };
        timer.schedule(task, 0, millisecond);
    }
}

