package com.learn.servlet.dao;

import com.learn.servlet.dao.exception.DaoSystemException;
import com.learn.servlet.entity.User;

public interface UserDao {
    public User selectByLogin(String login) throws DaoSystemException;
}
