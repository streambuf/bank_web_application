package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.ContributionDao;
import com.bank.mvc.domain.service.ContributionService;
import com.bank.mvc.models.Contribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 21.05.2015.
 */

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionDao contributionDao;

    @Override
    public Contribution getContributionById(long contributionId) {
        return contributionDao.getById(contributionId);
    }

    @Override
    public Collection<Contribution> getAllContributions() {
        return contributionDao.getAll();
    }

    @Override
    public void saveContribution(Contribution contribution) {
        contributionDao.save(contribution);
    }

    @Override
    public void deleteContribution(Contribution contribution) {
        contributionDao.delete(contribution);
    }
}
