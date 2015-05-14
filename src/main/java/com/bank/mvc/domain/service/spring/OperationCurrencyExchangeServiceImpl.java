package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.ExchangeRateDao;
import com.bank.mvc.dao.OperationCurrencyExchangeDao;
import com.bank.mvc.domain.service.AccountService;
import com.bank.mvc.domain.service.OperationCurrencyExchangeService;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.ExchangeRate;
import com.bank.mvc.models.ListCurrency;
import com.bank.mvc.models.OperationCurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Zalman on 12.05.2015.
 */

@Service
public class OperationCurrencyExchangeServiceImpl implements OperationCurrencyExchangeService {

    @Autowired
    private OperationCurrencyExchangeDao operationCurrencyExchangeDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    ExchangeRateDao exchangeRateDao;

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

        Account accountSender = accountService.getAccountById(operationCurrencyExchange.getAccountSenderId());
        Account accountPayee = accountService.getAccountById(operationCurrencyExchange.getAccountPayeeId());

        operationCurrencyExchange.setAccountSender(accountSender);
        operationCurrencyExchange.setAccountPayee(accountPayee);
        operationCurrencyExchange.setOperationDate(new Date());

        double quantityOfMoney = operationCurrencyExchange.getQuantityOfMoney();

        accountSender.setBalance(accountSender.getBalance() - quantityOfMoney);
        accountService.saveAccount(accountSender);

        ExchangeRate exchangeRateSend = exchangeRateDao.getByCurrency(accountSender.getCurrency());
        double senderCur = exchangeRateSend.getRate() / exchangeRateSend.getNominal();

        ExchangeRate exchangeRatePayee = exchangeRateDao.getByCurrency(accountPayee.getCurrency());
        double payeeCur = exchangeRatePayee.getRate() / exchangeRatePayee.getNominal();

        accountPayee.setBalance(accountPayee.getBalance() + quantityOfMoney * senderCur / payeeCur);
        accountService.saveAccount(accountPayee);

        operationCurrencyExchangeDao.save(operationCurrencyExchange);
    }

    @Override
    public void deleteOperationCurrencyExchange(OperationCurrencyExchange operationCurrencyExchange) {
        operationCurrencyExchangeDao.delete(operationCurrencyExchange);
    }

}
