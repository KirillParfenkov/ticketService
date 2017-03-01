package com.company.dao.factory.cinama;

import com.company.bean.Cinema;
import com.company.dao.Dao;

/**
 * Created by Kiryl_Parfiankou on 2/28/2017.
 */
public abstract class CinemaDaoFactory {

    public final static String APP_PROPERTY_PATH="application.properties";

    public static CinemaDaoFactory getInstance() {
        return new CinemaFileDaoFactory();
    }

    public abstract Dao<Cinema> createDao();
}
