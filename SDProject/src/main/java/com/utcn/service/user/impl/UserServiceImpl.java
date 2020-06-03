package com.utcn.service.user.impl;


import com.utcn.dao.user.BillingAddressDao;
import com.utcn.dao.user.UserDao;
import com.utcn.model.BillingAddress;
import com.utcn.model.User;
import com.utcn.model.UserRole;
import com.utcn.service.user.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BillingAddressDao billingAddressDao;

    @Override
    public void updateUserAccount(User user) {
        Optional<User> optionalUser = userDao.getUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            billingAddressDao.update(user.getBillingAddress());
            userDao.update(user);
        } else {
            throw new UsernameNotFoundException("");
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = userDao.getUserByEmail(email);
        user.ifPresent(
                u -> {
                    Hibernate.initialize(u.getBillingAddress());
                }
        );
        return user;
    }

    @Override
    public Optional<BillingAddress> getBillingAddressById(Long id) {
        return billingAddressDao.getById(id);
    }

    @Override
    public void deleteUserByEmail(String email) {
        Optional<User> optionalUser = userDao.getUserByEmail(email);
        optionalUser.ifPresent(o -> {
            userDao.delete(email);
        });
    }

    @Override
    public void insertAdmin(User user) {
        Optional<User> optionalUser = userDao.getUserByEmail(user.getEmail());
        optionalUser.ifPresentOrElse(
                foundUser -> {
                    throw new DataIntegrityViolationException("Invalid email!");
                },
                () -> {
                    user.setRole(UserRole.ADMIN);
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    userDao.save(user);
                });
    }

    @Override
    public void insertCustomer(User user) {

        Optional<User> optionalUser = userDao.getUserByEmail(user.getEmail());
        optionalUser.ifPresentOrElse(
                foundUser -> {
                    throw new DataIntegrityViolationException("Invalid email!");
                },
                () -> {
                    user.setRole(UserRole.CUSTOMER);
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    userDao.save(user);
                });
    }

    @Override
    public List<User> listAllUsers() {
        List<User> users = userDao.getAll();
        users.forEach(user -> Hibernate.initialize(user.getBillingAddress()));
        return users;
    }

    @Override
    public Optional<User> getByPhoneNumber(String phoneNumber) {
        return userDao.getByPhoneNumber(phoneNumber);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> foundOptionalUser = userDao.getUserByEmail(email);
        UserDetails userDetails;
        if (foundOptionalUser.isPresent()) {
            User foundUser = foundOptionalUser.get();
            List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(foundUser.getRole().toString()));
            userDetails = new org.springframework.security.core.userdetails.User(foundUser.getEmail(), foundUser.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return userDetails;
    }
}
