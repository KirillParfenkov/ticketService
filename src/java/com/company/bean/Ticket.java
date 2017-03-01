package com.company.bean;

/**
 * Created by Kiryl_Parfiankou on 2/28/2017.
 */
public class Ticket extends Entity{

    private String sessionId;
    private int seat;

    public Ticket(String sessionId, int seat) {
        this.sessionId = sessionId;
        this.seat = seat;
    }

    public Ticket() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "sessionId='" + sessionId + '\'' +
                ", seat=" + seat +
                '}';
    }
}
