package com.company.bean;

/**
 * Created by Kiryl_Parfiankou on 2/24/2017.
 */
public class Session extends Entity {

    private String time;
    private String movie;
    private String cinema;
    private int price;

    public Session() {
    }

    public Session(String time, String movie, String cinema, int price) {
        this.time = time;
        this.movie = movie;
        this.cinema = cinema;
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Session{" +
                "time='" + time + '\'' +
                ", movie='" + movie + '\'' +
                ", cinema='" + cinema + '\'' +
                ", price=" + price +
                '}';
    }
}
