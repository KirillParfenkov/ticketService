package com.company.dao;

import com.company.bean.Cinema;
import com.company.bean.Entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public class BaseFileDao<T extends Entity> implements Dao<T> {

    private String filePath = "D:\\No-Work\\data\\cinema.csv";
    private Converter<T> converter;

    public BaseFileDao(String filePath, Converter<T> converter) {
        this.filePath = filePath;
        this.converter = converter;
    }


    @Override
    public List<T> findAll() {

        List<T> entities = new ArrayList<>();

        try(
             FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr);
        ) {

            String line = null;
            while ((line = br.readLine()) != null) {
                entities.add(converter.convert(line));
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public T find(String id) {

        if (id == null) {
            throw new IllegalArgumentException("The id is not exist");
        }

        try(
                FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr);
        ) {

            String line = null;
            while ((line = br.readLine()) != null) {

                T entity = converter.convert(line);
                if (id.equals(entity.getId())) {
                    return entity;
                }
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public T insert(List<T> entity) {
        return null;
    }

    @Override
    public int update(List<T> entity) {
        return 0;
    }

    @Override
    public int delete(List<String> ids) {
        return 0;
    }
}
