package com.company.dao.factory.session;

import com.company.bean.Cinema;
import com.company.bean.Session;
import com.company.dao.BaseFileDao;
import com.company.dao.Converter;
import com.company.dao.Dao;
import com.company.dao.factory.cinama.CinemaDaoFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Kiryl_Parfiankou on 2/28/2017.
 */
public class SessionFileDaoFactory extends SessionDaoFactory {

    private Properties properties;

    public SessionFileDaoFactory() {

        properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(APP_PROPERTY_PATH);

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dao<Session> createDao() {

        String filePath = properties.getProperty("dao.file.session");

        Dao<Session> sessionDao = new BaseFileDao<>(filePath, new Converter<Session>() {

            private int ORDER_ID = 0;
            private int ORDER_TIME = 1;
            private int ORDER_CINEMA = 2;
            private int ORDER_MOVIE = 3;
            private int ORDER_PRICE = 4;

            @Override
            public Session convert(String line) {

                Dao<Cinema> cinemaDao = CinemaDaoFactory
                        .getInstance().createDao();

                if (line != null) {
                    Session session = new Session();
                    String[] snippets = line.split(";");
                    session.setId(snippets[ORDER_ID]);
                    session.setTime(snippets[ORDER_TIME]);
                    session.setCinema(snippets[ORDER_CINEMA]);
                    session.setPrice(Integer.valueOf(snippets[ORDER_PRICE]));
                    return session;
                }

                return null;
            }
        });

        return sessionDao;
    }
}