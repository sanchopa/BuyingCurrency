package com.luxoft.buying_currency.service;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by User on 25.12.2016.
 */
public class PropertiesServiceImpl implements PropertiesService {
    private static final Logger log = Logger.getLogger(PropertiesServiceImpl.class);

   public Properties getProperty (String filePath) {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            //"src/main/resources/config.properties"
            fis = new FileInputStream(filePath);
            property.load(fis);
        } catch (IOException e) {
            log.error("ОШИБКА: Файл свойств отсуствует!", e);
        }
        return property;
    }
}
