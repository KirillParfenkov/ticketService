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
import java.io.IOException;
import java.util.*;

/**
 * Created by Kiryl_Parfiankou on 3/14/2017.
 */
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        SessionDaoFactory sessionDaoFactory = SessionDaoFactory.getInstance();
        Dao<Session> dao = sessionDaoFactory.createDao();
        List<Session> sessionList = new ArrayList<>();
        Session session1 = new Session(
                "1",
                "1",
                "1",
                1
        );

        Session session2 = new Session(
                "2",
                "2",
                "2",
                2
        );

        Map<String, Session> testMap = new HashMap<String, Session>();
        testMap.put("key1", session1);
        //testMap.put("key2", session2);



        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(testMap);



        resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
