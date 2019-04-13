package com.learn.servlet.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MockController extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher page = request.getRequestDispatcher("a/b/c.jsp");

        page.forward(request, response);
        response.getWriter().write("Hello from servlet!");
    }
}