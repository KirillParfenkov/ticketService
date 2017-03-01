package com.company.dao.factory.session;

import com.company.bean.Cinema;
import com.company.bean.Session;
import com.company.dao.Dao;
import com.company.dao.factory.cinama.CinemaFileDaoFactory;

/**
 * Created by Kiryl_Parfiankou on 2/28/2017.
 */
public abstract class SessionDaoFactory {

    public final static String APP_PROPERTY_PATH="application.properties";

    public static SessionDaoFactory getInstance() {
        return new SessionFileDaoFactory();
    }

    public abstract Dao<Session> createDao();
}
