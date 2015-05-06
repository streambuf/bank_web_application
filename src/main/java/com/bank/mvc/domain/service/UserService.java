package com.bank.mvc.domain.service;

import com.bank.mvc.models.User;

import java.util.Collection;


public interface UserService {

    public Collection<User> getAllClients();

    public User getClientById(int clientId);

    public void saveClient(User user);

    public void deleteClient(User user);

}
