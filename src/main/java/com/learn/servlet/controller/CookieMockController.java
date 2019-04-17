package com.learn.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieMockController")
public class CookieMockController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie fromClient = null;
        for (Cookie cookie : cookies){
            fromClient = cookie;
            break;
        }
        if (fromClient == null){
            response.addCookie(new Cookie("counter", "1"));
            response.getWriter().write("You visit this page: " + 1 + "");
        } else {
            int visitCount = Integer.valueOf(fromClient.getValue());
            response.addCookie(new Cookie("counter", "" + (visitCount + 1)));
        }
    }
}