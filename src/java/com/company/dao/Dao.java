package com.company.dao;

import com.company.bean.Entity;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public interface Dao<T extends Entity> {

    List<T> findAll();

    T find(String id);

    T insert(List<T> entity);

    /**
     * @param entity
     * @return
     */
    int update(List<T> entity);

    int delete(List<String> ids);
}
