package com.bank.mvc.dao;

import com.bank.mvc.models.OperationCurrencyExchange;

import java.util.Collection;

/**
 * Created by Zalman on 12.05.2015.
 */
public interface OperationCurrencyExchangeDao {

    public Collection<OperationCurrencyExchange> getAll();

    public OperationCurrencyExchange getById(long operationCurrencyExchangeId);

    public void save(OperationCurrencyExchange operationCurrencyExchange);

    public void delete(OperationCurrencyExchange operationCurrencyExchange);

}
