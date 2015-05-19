package com.bank.mvc.dao;


import com.bank.mvc.models.CreditRepayment;

import java.util.Collection;

/**
 * Created by Zalman on 19.05.2015.
 */
public interface CreditRepaymentDao {

    public Collection<CreditRepayment> getAll();

    public CreditRepayment getById(long creditRepaymentId);

    public void save(CreditRepayment creditRepayment);

    public void delete(CreditRepayment creditRepayment);
}
