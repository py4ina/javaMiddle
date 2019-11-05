package com.learn.patterns.repository.dao;

import com.learn.patterns.repository.domainobject.Account;

import java.util.List;

public interface BloatAccountDAO {
    Account get(String userName);
    void create(Account account);
    void update(Account account);
    void delete(String userName);

    List getAccountByLastName(String lastName);
    List getAccountByAgeRange(int minAge, int maxAge);
    void updateEmailAddress(String userName, String newEmailAddress);
    void updateFullName(String userName, String firstName, String lastName);
}
