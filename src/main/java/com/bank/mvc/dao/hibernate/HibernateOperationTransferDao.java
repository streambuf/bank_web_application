package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.OperationTransferDao;
import com.bank.mvc.models.OperationTransfer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 11.05.2015.
 */

@Repository
@Transactional
public class HibernateOperationTransferDao implements OperationTransferDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<OperationTransfer> getAll() {
        String hql = "from OperationTransfer";
        return sessionFactory.getCurrentSession().
                createQuery("from OperationTransfer").list();
    }

    @Override
    public OperationTransfer getById(long operationTransferId) {
        return (OperationTransfer)sessionFactory.getCurrentSession()
                .get(OperationTransfer.class, operationTransferId);
    }

    @Override
    public void save(OperationTransfer operationTransfer) {
        sessionFactory.getCurrentSession().merge(operationTransfer);
    }

    @Override
    public void delete(OperationTransfer operationTransfer) {
        sessionFactory.getCurrentSession().delete(operationTransfer);
    }
}
