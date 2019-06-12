package com.learn.servlet.controller;

import com.learn.servlet.dao.ProductDao;
import com.learn.servlet.dao.exception.DaoSystemException;
import com.learn.servlet.dao.exception.NoSuchEntityException;
import com.learn.servlet.entity.Product;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class ProductControllerTest {
    private static final String PARAM_ID = "id";
    private static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    private static final String PAGE_OK = "product.jsp";
    private static final String PAGE_ERROR = "error.jsp";

    ProductController controller;

    @Before
    public void setUp() {
        this.controller = new ProductController();
    }

    @Test
    public void test_no_param() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter(PARAM_ID)).thenReturn(null);
        HttpServletResponse response = mock(HttpServletResponse.class);

        controller.doGet(request, response);

        verify(request).getParameter(PARAM_ID);
        verify(response).sendRedirect(PAGE_ERROR);
        verifyNoMoreInteractions(request, response);
    }

    @Test
    public void test_bad_param() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter(PARAM_ID)).thenReturn("abc");
        HttpServletResponse response = mock(HttpServletResponse.class);

        controller.doGet(request, response);

        verify(request).getParameter(PARAM_ID);
        verify(response, times(2)).sendRedirect(PAGE_ERROR);
        verifyNoMoreInteractions(request, response);
    }

    @Test
    public void test_no_in_dao() throws ServletException, IOException, DaoSystemException, NoSuchEntityException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ProductDao dao = mock(ProductDao.class);

        when(request.getParameter(PARAM_ID)).thenReturn("123");
        when(dao.selectById(anyInt())).thenThrow(new NoSuchEntityException(""));
        controller.productDao = dao;

        controller.doGet(request, response);

        verify(request).getParameter(PARAM_ID);
        verify(dao).selectById(123);
        verify(response, times(2)).sendRedirect(PAGE_ERROR);
        verifyNoMoreInteractions(request, response, dispatcher, dao);
    }

    @Test
    public void test_ok() throws ServletException, IOException, DaoSystemException, NoSuchEntityException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ProductDao dao = mock(ProductDao.class);
        Product product = new Product(123, "Paper");

        when(request.getParameter(PARAM_ID)).thenReturn("123");
        when(dao.selectById(anyInt())).thenReturn(product);
        when(request.getRequestDispatcher(PAGE_OK)).thenReturn(dispatcher);
        controller.productDao = dao;

        controller.doGet(request, response);

        verify(request).getParameter(PARAM_ID);
        verify(dao).selectById(123);
        verify(request).setAttribute(ATTRIBUTE_MODEL_TO_VIEW, product);
        verify(request).getRequestDispatcher(PAGE_OK);
        verify(dispatcher).forward(request, response);
        verifyNoMoreInteractions(request, response, dispatcher, dao);
    }
}