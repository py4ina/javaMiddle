package com.learn.patterns.repository.repository;

import com.learn.patterns.repository.domainobject.Account;

public interface AccountSpecification {
    boolean specified(Account account);
}
