package com.bank.mvc.dao;

import com.bank.mvc.models.Passport;

import java.util.Collection;

/**
 * Created by Zalman on 23.05.2015.
 */
public interface PassportDao {

    public Collection<Passport> getAll();

    public Passport getById(long passportId);

    public void save(Passport passport);

    public void delete(Passport passport);
}
