package com.bank.mvc.domain.service;

import com.bank.mvc.models.CategoryServices;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface CategoryServicesService {

    public Collection<CategoryServices> getAllCategoryServices();

    public CategoryServices getCategoryServicesById(long categoryServicesId);

    public void saveCategoryServices(CategoryServices categoryServices);

    public void deleteCategoryServices(CategoryServices categoryServices);
}
