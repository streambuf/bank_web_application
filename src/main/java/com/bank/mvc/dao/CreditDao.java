package com.bank.mvc.dao;

import com.bank.mvc.models.Credit;

import java.util.Collection;

/**
 * Created by Zalman on 19.05.2015.
 */
public interface CreditDao {

    public Collection<Credit> getAll();

    public Collection<Credit> getByUserId(long userId);

    public Collection<Credit> getAllUnconfirmed();

    public Credit getById(long creditId);

    public void save(Credit credit);

    public void delete(Credit credit);
}
