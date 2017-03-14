package com.company.controller;

import com.company.bean.Ticket;
import com.company.dao.factory.ticket.TicketDatabaseDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 3/7/2017.
 */
public class HelloController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TicketDatabaseDao ticketDao = new TicketDatabaseDao();
        List<Ticket> tickets = ticketDao.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(tickets);

        resp.getWriter().println(result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
