package com.bank.mvc.domain.service;

import com.bank.mvc.dao.AccountDao;
import com.bank.mvc.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 10.05.2015.
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getAccountById(long accountId) {
        return accountDao.getById(accountId);
    }

    @Override
    public Collection<Account> getAll() {
        return accountDao.getAll();
    }
}
