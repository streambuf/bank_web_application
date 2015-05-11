package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.UserDao;
import com.bank.mvc.domain.service.UserService;
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
    public Collection<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User getUserById(long userId) {
        return userDao.getById(userId);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getById(Long.parseLong(username));

        if (user == null) throw new UsernameNotFoundException("username: " + username + " not found!");

        return user;
    }
}
