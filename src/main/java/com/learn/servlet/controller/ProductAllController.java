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
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "productId";
    public static final String PAGE_OK = "productAll.jsp";
    public static final String PAGEERROR = "error.jsp";

    private ProductDao productDao = new ProductDaoMock();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> model = productDao.selectAll();
            request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
            RequestDispatcher dispatcher = request.getRequestDispatcher();
            dispatcher.forward(request, response);
            return;
        } catch (DaoSystemException e){
            e.printStackTrace();
        }
    }
}
