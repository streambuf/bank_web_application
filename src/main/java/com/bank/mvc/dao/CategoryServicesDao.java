package com.bank.mvc.dao;

import com.bank.mvc.models.CategoryServices;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface CategoryServicesDao {

    public Collection<CategoryServices> getAll();

    public CategoryServices getById(long categoryServicesId);

    public void save(CategoryServices categoryServices);

    public void delete(CategoryServices categoryServices);

}
