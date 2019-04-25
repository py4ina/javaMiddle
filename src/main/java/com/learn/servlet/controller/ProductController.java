package com.learn.servlet.controller;

import com.learn.servlet.dao.ProductDao;
import com.learn.servlet.dao.exception.DaoSystemException;
import com.learn.servlet.dao.exception.NoSuchEntityException;
import com.learn.servlet.dao.impl.ProductDaoMock;
import com.learn.servlet.entity.Product;
import com.learn.servlet.inject.DependencyInjectionServlet;
import com.learn.servlet.inject.Inject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends DependencyInjectionServlet {
    private static final String PARAM_ID = "id";
    private static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    private static final String PAGE_OK = "product.jsp";
    private static final String PAGE_ERROR = "error.jsp";

    @Inject("productDao")
    private ProductDao productDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(PARAM_ID);
        if (idStr != null) {
            try {
                Integer id = Integer.valueOf(idStr);
                Product model = productDao.selectById(id);
                request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);

                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK);
                dispatcher.forward(request, response);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DaoSystemException e){
                e.printStackTrace();
            }
        }
        response.sendRedirect(PAGE_ERROR);
    }
}