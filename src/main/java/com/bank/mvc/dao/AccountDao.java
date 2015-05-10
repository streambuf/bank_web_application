package com.bank.mvc.dao;

import com.bank.mvc.models.Account;
import com.bank.mvc.models.User;

import java.util.Collection;

/**
 * Created by Zalman on 10.05.2015.
 */
public interface AccountDao {

    public Collection<Account> getAll();
    public Account getById(long userId);
    public void save(Account user);
    public void delete(Account user);

}
