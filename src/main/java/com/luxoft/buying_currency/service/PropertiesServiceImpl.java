package com.luxoft.buying_currency.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by User on 25.12.2016.
 */
@Service("propertiesService")
public class PropertiesServiceImpl implements PropertiesService {
    private static final Logger log = Logger.getLogger(PropertiesServiceImpl.class);

   private Properties getProperties() {
        InputStream fis;
        Properties property = new Properties();
        try {
            //"src/main/resources/config.properties"
            fis = getClass().getResourceAsStream("/defaultUser.properties") ;
            property.load(fis);
        } catch (IOException e) {
            log.error("ОШИБКА: Файл свойств отсуствует!", e);
        }
        return property;
    }

    public String getDefaultBalanceRUB() {
        return getProperties().getProperty("MMM1");
    }
    public String getDefaultBalanceUSD() {
        return getProperties().getProperty("MMM2");
    }
    public String getDefaultBalanceEUR() {
        return getProperties().getProperty("MMM3");
    }
}
