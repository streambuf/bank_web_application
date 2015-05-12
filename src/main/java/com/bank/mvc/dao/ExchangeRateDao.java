package com.bank.mvc.dao;


import com.bank.mvc.models.ExchangeRate;
import com.bank.mvc.models.ListCurrency;

/**
 * Created by Zalman on 12.05.2015.
 */
public interface ExchangeRateDao {

    public ExchangeRate getByCurrency(ListCurrency currency);
}
