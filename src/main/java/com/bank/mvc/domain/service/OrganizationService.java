package com.bank.mvc.domain.service;

import com.bank.mvc.models.Organization;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface OrganizationService {

    public Collection<Organization> getAllOrganizations();

    public Organization getOrganizationById(long organizationId);

    public void saveOrganization(Organization organization);

    public void deleteOrganization(Organization organization);
}
