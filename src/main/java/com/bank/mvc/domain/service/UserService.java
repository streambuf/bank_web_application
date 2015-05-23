package com.bank.mvc.domain.service;

import com.bank.mvc.models.Passport;
import com.bank.mvc.models.User;

import java.util.Collection;


public interface UserService {

    public Collection<User> getAllUsers();

    public Collection<User> getAllUnconfirmedUsers();

    public User getUserById(long userId);

    public void saveUser(User user);

    public void deleteUser(User user);

    public void savePassport(Passport passport);

}
