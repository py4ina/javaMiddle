package com.learn.servlet.dao;

import com.learn.servlet.dao.exception.DaoSystemException;
import com.learn.servlet.dao.exception.NoSuchEntityException;
import com.learn.servlet.entity.Product;

import java.util.List;

public interface ProductDao {
    Product selectById(int id) throws DaoSystemException, NoSuchEntityException;
    List<Product> selectAll() throws DaoSystemException;
}
