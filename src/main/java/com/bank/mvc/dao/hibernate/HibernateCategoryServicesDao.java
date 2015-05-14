package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.CategoryServicesDao;
import com.bank.mvc.models.CategoryServices;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */

@Repository
@Transactional
public class HibernateCategoryServicesDao implements CategoryServicesDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<CategoryServices> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from CategoryServices").list();
    }

    @Override
    public CategoryServices getById(long categoryServicesId) {
        return (CategoryServices)sessionFactory.getCurrentSession()
                .get(CategoryServices.class, categoryServicesId);
    }

    @Override
    public void save(CategoryServices categoryServices) {
        sessionFactory.getCurrentSession().merge(categoryServices);
    }

    @Override
    public void delete(CategoryServices categoryServices) {
        sessionFactory.getCurrentSession().delete(categoryServices);
    }    

}
