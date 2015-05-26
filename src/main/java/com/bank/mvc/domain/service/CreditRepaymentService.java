package com.bank.mvc.domain.service;

import com.bank.mvc.models.CreditRepayment;

import java.util.Collection;

/**
 * Created by Zalman on 19.05.2015.
 */
public interface CreditRepaymentService {

    public Collection<CreditRepayment> getAllCreditRepayments();

    public CreditRepayment getCreditRepaymentById(long creditRepaymentId);

    public void saveCreditRepayment(CreditRepayment creditRepayment);

    public void deleteCreditRepayment(CreditRepayment creditRepayment);


}
