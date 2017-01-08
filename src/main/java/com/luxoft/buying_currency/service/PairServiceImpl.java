package com.luxoft.buying_currency.service;

import com.luxoft.buying_currency.dao.PairDao;
import com.luxoft.buying_currency.model.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


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

    public double generateRandomDecimal() {
        int rnd = new Random(System.currentTimeMillis()).nextInt(5000 - 100) + 100;
        return rnd / 100;
    }

    @Override
    @Transactional
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
    @Transactional
    public void savePair(Pair pair) {
        dao.save(pair);
    }
}
