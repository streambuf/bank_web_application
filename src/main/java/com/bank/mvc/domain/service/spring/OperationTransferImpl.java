package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.OperationTransferDao;
import com.bank.mvc.domain.service.OperationTransferService;
import com.bank.mvc.models.OperationTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zalman on 11.05.2015.
 */
@Service
public class OperationTransferImpl implements OperationTransferService {

    @Autowired
    private OperationTransferDao operationTransferDao;

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
        operationTransferDao.save(operationTransfer);
    }

    @Override
    public void deleteOperationTransfer(OperationTransfer operationTransfer) {
        operationTransferDao.delete(operationTransfer);
    }



}
