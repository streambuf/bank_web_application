package com.bank.mvc.domain.service;

import com.bank.mvc.models.Client;

import java.util.Collection;


public interface ClientService {

    public Collection<Client> getAllClients();

    public Client getClientById(int clientId);

    public void saveClient(Client client);

    public void deleteClient(Client client);

}
