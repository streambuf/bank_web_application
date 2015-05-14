package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.OrganizationDao;
import com.bank.mvc.domain.service.OrganizationService;
import com.bank.mvc.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public Organization getOrganizationById(long organizationId) {
        return organizationDao.getById(organizationId);
    }

    @Override
    public Collection<Organization> getAllOrganizations() {
        return organizationDao.getAll();
    }

    @Override
    public void saveOrganization(Organization organization) {
        organizationDao.save(organization);
    }

    @Override
    public void deleteOrganization(Organization organization) {
        organizationDao.delete(organization);
    }
}
