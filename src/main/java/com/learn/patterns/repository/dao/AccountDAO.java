package com.learn.patterns.repository.dao;

import com.learn.patterns.repository.domainobject.Account;

public interface AccountDAO {
    Account get(String userName);
    void create(Account account);
    void update(Account account);
    void delete(String userName);
}
