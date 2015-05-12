package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.AccountDao;
import com.bank.mvc.dao.OperationTransferDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.OperationTransferService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.OperationTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Zalman on 11.05.2015.
 */
@Service
public class OperationTransferServiceImpl implements OperationTransferService {

    @Autowired
    private OperationTransferDao operationTransferDao;

    @Autowired
    private AccountService accountService;


    @Override
    public Collection<OperationTransfer> getAllOperationTransfers() {
        return operationTransferDao.getAll();
    }

    @Override
    public OperationTransfer getOperationTransferById(long operationTransferId) {
        return operationTransferDao.getById(operationTransferId);
    }

    @Override
    public void saveOperationTransfer(OperationTransfer operationTransfer) {
        Account accountSender = accountService.getAccountById(operationTransfer.getAccountSenderId());
        operationTransfer.setAccountSender(accountSender);
        operationTransfer.setUser(accountSender.getUser());
        operationTransfer.setOperationDate(new Date());

        accountSender.setBalance(accountSender.getBalance() - operationTransfer.getQuantityOfMoney());
        accountService.saveAccount(accountSender);

        Account accountPayee = accountService.getAccountById(operationTransfer.getAccountPayee());
        if (accountPayee != null) {
            accountPayee.setBalance(accountPayee.getBalance() + operationTransfer.getQuantityOfMoney());
            accountService.saveAccount(accountPayee);
        }

        operationTransferDao.save(operationTransfer);
    }

    @Override
    public void deleteOperationTransfer(OperationTransfer operationTransfer) {
        operationTransferDao.delete(operationTransfer);
    }



}
