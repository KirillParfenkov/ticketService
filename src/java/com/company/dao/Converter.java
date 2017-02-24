package com.company.dao;

import com.company.bean.Entity;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public interface Converter<T extends Entity> {
    T convert(String line);
}
