package com.company.dao.factory;

import com.company.bean.Cinema;
import com.company.dao.Dao;

import java.io.File;

/**
 * Created by Kiryl_Parfiankou on 2/28/2017.
 */
public abstract class CinemaDaoFactory {

    public static final String PROPERTY_FILE_PATH = "application.properties";

    private static CinemaDaoFactory cinemaDaoFactory;

    public static CinemaDaoFactory getInstance() {
        if (cinemaDaoFactory == null) {
            cinemaDaoFactory = new CinemaFileDaoFactory();
        }
        return cinemaDaoFactory;
    }

    public abstract Dao<Cinema> createDao();

}
