package com.company.dao.factory.ticket;

import com.company.bean.Ticket;
import com.company.dao.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Kiryl_Parfiankou on 2/28/2017.
 */
public class TicketDatabaseDao implements Dao<Ticket> {

    @Override
    public List<Ticket> findAll() {

        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "password");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");

        List<Ticket> tickets = new ArrayList<>();

        try(
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/ticket-schema", properties);
                ) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tickets");


            Ticket ticket;
            while (resultSet.next()) {

                ticket = new Ticket();
                ticket.setId(String.valueOf(resultSet.getInt("id")).toString());
                ticket.setSessionId(resultSet.getString("sessionId"));
                ticket.setSeat(resultSet.getInt("seat"));

                tickets.add(ticket);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public Ticket find(String id) {
        return null;
    }

    @Override
    public Ticket insert(List<Ticket> entity) {
        return null;
    }

    @Override
    public int update(List<Ticket> entity) {
        return 0;
    }

    @Override
    public int delete(List<String> ids) {
        return 0;
    }
}
