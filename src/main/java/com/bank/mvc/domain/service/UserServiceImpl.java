package com.bank.mvc.domain.service;

import com.bank.mvc.dao.UserDao;
import com.bank.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public Collection<User> getAllClients() {
        return userDao.getAll();
    }

    @Override
    public User getClientById(int clientId) {
        return userDao.getById(clientId);
    }

    @Override
    public void saveClient(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteClient(User user) {
        userDao.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.getByUsername(username);

        if (user == null) throw new UsernameNotFoundException("username: " + username + " not found!");

        return user;
    }
}
