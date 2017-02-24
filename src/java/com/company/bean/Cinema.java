package com.company.bean;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public class Cinema extends Entity {

    private String name;
    private String address;

    public Cinema() {
    }

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}