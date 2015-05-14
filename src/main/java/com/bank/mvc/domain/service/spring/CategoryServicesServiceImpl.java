package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.CategoryServicesDao;
import com.bank.mvc.domain.service.CategoryServicesService;
import com.bank.mvc.models.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */

@Service
public class CategoryServicesServiceImpl implements CategoryServicesService {

    @Autowired
    private CategoryServicesDao categoryServicesDao;

    @Override
    public CategoryServices getCategoryServicesById(long categoryServicesId) {
        return categoryServicesDao.getById(categoryServicesId);
    }

    @Override
    public Collection<CategoryServices> getAllCategoryServices() {
        return categoryServicesDao.getAll();
    }

    @Override
    public void saveCategoryServices(CategoryServices categoryServices) {
        categoryServicesDao.save(categoryServices);
    }

    @Override
    public void deleteCategoryServices(CategoryServices categoryServices) {
        categoryServicesDao.delete(categoryServices);
    }
}
