package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.OperationServicesPaymentDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.OperationServicesPaymentService;
import com.bank.mvc.domain.service.OrganizationService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.OperationServicesPayment;
import com.bank.mvc.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Zalman on 14.05.2015.
 */

@Service
public class OperationServicesPaymentImpl implements OperationServicesPaymentService {

    @Autowired
    private OperationServicesPaymentDao operationServicesPaymentDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrganizationService organizationService;

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
        Account accountSender = accountService.getAccountById(operationServicesPayment.getAccountSenderId());
        Organization organization = organizationService.getOrganizationById(operationServicesPayment.getOrganizationId());

        operationServicesPayment.setAccountSender(accountSender);
        operationServicesPayment.setOrganization(organization);
        operationServicesPayment.setOperationDate(new Date());

        double quantityOfMoney = operationServicesPayment.getQuantityOfMoney();

        accountSender.setBalance(accountSender.getBalance() - quantityOfMoney);
        accountService.saveAccount(accountSender);

        operationServicesPaymentDao.save(operationServicesPayment);
    }

    @Override
    public void deleteOperationServicesPayment(OperationServicesPayment operationServicesPayment) {
        operationServicesPaymentDao.delete(operationServicesPayment);
    }
}
