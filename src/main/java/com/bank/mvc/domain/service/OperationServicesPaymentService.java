package com.bank.mvc.domain.service;

import com.bank.mvc.models.OperationServicesPayment;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface OperationServicesPaymentService {

    public Collection<OperationServicesPayment> getAllOperationServicesPayments();

    public OperationServicesPayment getOperationServicesPaymentById(long operationServicesPaymentId);

    public void saveOperationServicesPayment(OperationServicesPayment operationServicesPayment);

    public void deleteOperationServicesPayment(OperationServicesPayment operationServicesPayment);
}
