package com.company.controller;

import com.company.bean.Ticket;
import com.company.dao.factory.ticket.TicketDatabaseDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 3/14/2017.
 */
public class TicketController extends HttpServlet {


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

        BufferedReader br = req.getReader();
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            Ticket ticket = objectMapper.readValue(br, Ticket.class);
            resp.setStatus(200);


        } catch (JsonParseException e) {
            resp.setStatus(404);
        }
    // JsonParseException, JsonMappingException
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
