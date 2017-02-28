package com.company.dao.factory;

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
        System.out.println(System.getProperty("user.dir"));
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CinemaDaoFactory.PROPERTY_FILE_PATH);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Dao<Cinema> createDao() {

        String cinemaFilePath = properties.getProperty("dao.file.cinema");

        Dao<Cinema> cinemaDao = new BaseFileDao<>(cinemaFilePath, new Converter<Cinema>() {

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
