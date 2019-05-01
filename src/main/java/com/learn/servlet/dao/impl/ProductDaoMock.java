package com.learn.servlet.dao.impl;

import com.learn.servlet.dao.exception.DaoSystemException;
import com.learn.servlet.dao.ProductDao;
import com.learn.servlet.dao.exception.NoSuchEntityException;
import com.learn.servlet.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductDaoMock implements ProductDao {
    private final Map<Integer, Product> memory = new ConcurrentHashMap<>();

    public ProductDaoMock() {
        this.memory.put(1, new Product(1, "Bread"));
        this.memory.put(2, new Product(2, "Paper"));
        this.memory.put(3, new Product(3, "Sugar"));
    }

    @Override
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException {
//        if (id == 123){
//            throw new Error("Hello from magic bad id!");
//        }

        Product product = memory.get(id);
        if (product == null){
            throw new NoSuchEntityException("No Product for id == '"+id+"', only for " + memory.keySet());
        }
        return product;
    }

    @Override
    public List<Product> selectAll() throws DaoSystemException {
        return new ArrayList<>(memory.values());
    }
}
