package com.company.controller;

import com.company.bean.Session;
import com.company.dao.Dao;
import com.company.dao.factory.session.SessionDaoFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.collections.MappingChange;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Kiryl_Parfiankou on 3/14/2017.
 */
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionDaoFactory sessionDaoFactory = SessionDaoFactory.getInstance();
        Dao<Session> dao = sessionDaoFactory.createDao();
        List<Session> sessionList = dao.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(sessionList);
        resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = req.getReader();
        String line = "";

        while ((line = br.readLine()) != null) {
            System.out.println("Message:");
            System.out.println(line);
        }
    }
}
