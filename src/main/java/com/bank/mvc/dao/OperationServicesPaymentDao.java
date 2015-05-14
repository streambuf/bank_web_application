package com.bank.mvc.dao;

import com.bank.mvc.models.OperationServicesPayment;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface OperationServicesPaymentDao {

    public Collection<OperationServicesPayment> getAll();

    public OperationServicesPayment getById(long operationServicesPaymentId);

    public void save(OperationServicesPayment operationServicesPayment);

    public void delete(OperationServicesPayment operationServicesPayment);
}
