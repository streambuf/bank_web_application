package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.PassportDao;
import com.bank.mvc.dao.UserDao;
import com.bank.mvc.domain.service.UserService;
import com.bank.mvc.models.Passport;
import com.bank.mvc.models.User;
import com.bank.mvc.models.UserRole;
import com.bank.mvc.models.enums.ListRole;
import com.bank.mvc.utils.PasswordEncoder;
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

    @Autowired
    private PassportDao passportDao;

    @Override
    public Collection<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public Collection<User> getAllUnconfirmedUsers() { return userDao.getAllUnconfirmed(); }

    @Override
    public Collection<User> getAllConfirmedUsers() { return userDao.getAllConfirmed(); }

    @Override
    public User getUserById(long userId) {
        return userDao.getById(userId);
    }

    @Override
    public void saveUser(User user) {
        // encode password sha256
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

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

    @Override
    public void savePassport(Passport passport) {
        User user = getUserById(passport.getUserId());
        passport.setUser(user);
        user.setPassport(passport);
        UserRole userRole = new UserRole();
        userRole.setId(1);
        userRole.setListRole(ListRole.ROLE_CLIENT);
        userRole.addUser(user);
        user.addUserRole(userRole);
        userDao.saveOrUpdate(user);
    }
}
