package com.bank.mvc.dao;

import com.bank.mvc.models.Account;

import java.util.Collection;

/**
 * Created by Zalman on 10.05.2015.
 */
public interface AccountDao {

    public Collection<Account> getAll();

    public Account getById(long accountId);

    public void save(Account account);

    public void delete(Account account);

}
