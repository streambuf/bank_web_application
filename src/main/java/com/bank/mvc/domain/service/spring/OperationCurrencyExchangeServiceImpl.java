package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.OperationCurrencyExchangeDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.OperationCurrencyExchangeService;
import com.bank.mvc.models.OperationCurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 12.05.2015.
 */

@Service
public class OperationCurrencyExchangeServiceImpl implements OperationCurrencyExchangeService {

    @Autowired
    private OperationCurrencyExchangeDao operationCurrencyExchangeDao;

    @Autowired
    private AccountService accountService;

    @Override
    public Collection<OperationCurrencyExchange> getAllOperationCurrencyExchanges() {
        return operationCurrencyExchangeDao.getAll();
    }

    @Override
    public OperationCurrencyExchange getOperationCurrencyExchangeById(long operationCurrencyExchangeId) {
        return operationCurrencyExchangeDao.getById(operationCurrencyExchangeId);
    }

    @Override
    public void saveOperationCurrencyExchange(OperationCurrencyExchange operationCurrencyExchange) {
//        Account accountSender = operationCurrencyExchange.getAccountSender();
//        accountSender.setBalance(accountSender.getBalance() - operationCurrencyExchange.getQuantityOfMoney());
//        accountService.saveAccount(accountSender);
//
//        Account accountPayee = accountService.getAccountById(operationCurrencyExchange.getAccountPayee());
//        if (accountPayee != null) {
//            accountPayee.setBalance(accountPayee.getBalance() + operationCurrencyExchange.getQuantityOfMoney());
//            accountService.saveAccount(accountPayee);
//        }

        operationCurrencyExchangeDao.save(operationCurrencyExchange);
    }

    @Override
    public void deleteOperationCurrencyExchange(OperationCurrencyExchange operationCurrencyExchange) {
        operationCurrencyExchangeDao.delete(operationCurrencyExchange);
    }

}
