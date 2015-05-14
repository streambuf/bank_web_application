package com.bank.mvc.dao;

import com.bank.mvc.models.Organization;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface OrganizationDao {
    public Collection<Organization> getAll();

    public Organization getById(long organizationId);

    public void save(Organization organization);

    public void delete(Organization organization);
}
