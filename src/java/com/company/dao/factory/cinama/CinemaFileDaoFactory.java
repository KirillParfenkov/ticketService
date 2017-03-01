package com.company.dao.factory.cinama;

import com.company.bean.Cinema;
import com.company.dao.BaseFileDao;
import com.company.dao.Converter;
import com.company.dao.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Kiryl_Parfiankou on 2/28/2017.
 */
public class CinemaFileDaoFactory extends CinemaDaoFactory {

    private Properties properties;

    public CinemaFileDaoFactory() {

        properties = new Properties();
        InputStream input = getClass().getClassLoader()
                .getResourceAsStream(APP_PROPERTY_PATH);

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dao<Cinema> createDao() {

        String filePath = properties.getProperty("dao.file.cinema");
        Dao<Cinema> cinemaDao = new BaseFileDao<>(filePath, new Converter<Cinema>() {

            private int ORDER_ID = 0;
            private int ORDER_NAME = 1;
            private int ORDER_ADDRESS = 2;

            @Override
            public Cinema convert(String line) {

                if (line != null) {
                    Cinema cinema = new Cinema();
                    String[] snippets = line.split(";");
                    cinema.setId(snippets[ORDER_ID]);
                    cinema.setName(snippets[ORDER_NAME]);cinema.setAddress(snippets[ORDER_ADDRESS]);
                    return cinema;
                }

                return null;
            }
        });

        return cinemaDao;
    }
}
