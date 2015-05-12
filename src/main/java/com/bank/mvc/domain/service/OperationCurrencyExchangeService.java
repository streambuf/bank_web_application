package com.bank.mvc.domain.service;

import com.bank.mvc.models.OperationCurrencyExchange;

import java.util.Collection;

/**
 * Created by Zalman on 12.05.2015.
 */
public interface OperationCurrencyExchangeService {

    public Collection<OperationCurrencyExchange> getAllOperationCurrencyExchanges();

    public OperationCurrencyExchange getOperationCurrencyExchangeById(long operationCurrencyExchangeId);

    public void saveOperationCurrencyExchange(OperationCurrencyExchange operationCurrencyExchange);

    public void deleteOperationCurrencyExchange(OperationCurrencyExchange operationCurrencyExchange);
    
}
