package com.learn.servlet.controller;

import com.learn.servlet.dao.ProductDao;
import com.learn.servlet.dao.exception.DaoSystemException;
import com.learn.servlet.dao.impl.ProductDaoMock;
import com.learn.servlet.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductAllController")
public class ProductAllController extends HttpServlet {
    private static final String PARAM_ID = "id";
    private static final String ATTRIBUTE_MODEL_TO_VIEW = "productList";
    private static final String PAGE_OK = "productAll.jsp";
    private static final String PAGE_ERROR = "error.jsp";

    private ProductDao productDao = new ProductDaoMock();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> model = productDao.selectAll();
            request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK);
            dispatcher.forward(request, response);
            return;
        } catch (DaoSystemException e){
            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }
}
