package com.bank.mvc.domain.service;

import com.bank.mvc.dao.ClientDao;
import com.bank.mvc.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Collection<Client> getAllClients() {
        return clientDao.getAll();
    }

    @Override
    public Client getClientById(int clientId) {
        return clientDao.getById(clientId);
    }

    @Override
    public void saveClient(Client client) {
        clientDao.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
