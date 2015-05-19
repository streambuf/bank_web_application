package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.CreditDao;
import com.bank.mvc.domain.service.CreditService;
import com.bank.mvc.models.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 19.05.2015.
 */

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditDao creditDao;

    @Override
    public Credit getCreditById(long creditId) {
        return creditDao.getById(creditId);
    }

    @Override
    public Collection<Credit> getAllCredits() {
        return creditDao.getAll();
    }

    @Override
    public void saveCredit(Credit credit) {
        creditDao.save(credit);
    }

    @Override
    public void deleteCredit(Credit credit) {
        creditDao.delete(credit);
    }
}
