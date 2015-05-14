package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.OperationServicesPaymentDao;
import com.bank.mvc.domain.service.OperationServicesPaymentService;
import com.bank.mvc.models.OperationServicesPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */

@Service
public class OperationServicesPaymentImpl implements OperationServicesPaymentService {

    @Autowired
    private OperationServicesPaymentDao operationServicesPaymentDao;

    @Override
    public OperationServicesPayment getOperationServicesPaymentById(long operationServicesPaymentId) {
        return operationServicesPaymentDao.getById(operationServicesPaymentId);
    }

    @Override
    public Collection<OperationServicesPayment> getAllOperationServicesPayments() {
        return operationServicesPaymentDao.getAll();
    }

    @Override
    public void saveOperationServicesPayment(OperationServicesPayment operationServicesPayment) {
        operationServicesPaymentDao.save(operationServicesPayment);
    }

    @Override
    public void deleteOperationServicesPayment(OperationServicesPayment operationServicesPayment) {
        operationServicesPaymentDao.delete(operationServicesPayment);
    }
}
