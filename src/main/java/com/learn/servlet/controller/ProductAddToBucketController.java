package com.learn.servlet.controller;

import com.learn.servlet.dao.ProductDao;
import com.learn.servlet.dao.exception.DaoSystemException;
import com.learn.servlet.dao.exception.NoSuchEntityException;
import com.learn.servlet.dao.impl.ProductDaoMock;
import com.learn.servlet.entity.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.learn.servlet.controller.SessionAttributes.PRODUCT_IN_BUCKET;
import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

@WebServlet(name = "ProductAddToBucketController")
public class ProductAddToBucketController extends HttpServlet {
    private static final String PAGE_ERROR = "productAll.do";
    private static final String PARAM_ID = "id";


    private ProductDao productDao = new ProductDaoMock();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter(PARAM_ID);
        if (idStr != null){
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = productDao.selectById(id);

                HttpSession session = request.getSession(true);
                Map<Product, Integer> oldBucket = (Map<Product, Integer> ) session.getAttribute(PRODUCT_IN_BUCKET);
                if (oldBucket == null){
                    session.setAttribute(PRODUCT_IN_BUCKET, singletonMap(product, 1));
                } else {
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                    if (!oldBucket.containsKey(product)){
                        newBucket.put(product, 1);
                    } else {
                        newBucket.put(product, newBucket.get(product) + 1);
                    }
                    session.setAttribute(PRODUCT_IN_BUCKET, unmodifiableMap(newBucket));
                }
                String newLocation = "product.do?id="+id;
                response.sendRedirect(newLocation);
                return;

            } catch (DaoSystemException | NoSuchEntityException e) {
                e.printStackTrace();
            }
            response.sendRedirect(PAGE_ERROR);
        }
    }
}
