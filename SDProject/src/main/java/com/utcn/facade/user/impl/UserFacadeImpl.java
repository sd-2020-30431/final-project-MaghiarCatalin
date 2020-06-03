package com.utcn.facade.user.impl;

import com.utcn.data.user.UserData;
import com.utcn.data.user.UserViewData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.user.UserFacade;
import com.utcn.model.BillingAddress;
import com.utcn.model.User;
import com.utcn.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserData> converter;

    @Autowired
    private Converter<UserData, User> reverseConverter;

    @Autowired
    private Converter<UserViewData, User> viewReverseConverter;

    @Override
    public void updateUserAccount(String email, UserViewData userViewData) {
        User user = viewReverseConverter.convert(userViewData);
        user.setEmail(email);
        Optional<User> oldUser = userService.getUserByEmail(email);
        if (oldUser.isPresent()) {
            user.setPassword(oldUser.get().getPassword());
            user.setRole(oldUser.get().getRole());
            BillingAddress billingAddress = user.getBillingAddress();
            billingAddress.setId(oldUser.get().getBillingAddress().getId());
            user.setBillingAddress(billingAddress);
            userService.updateUserAccount(user);
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public Optional<BillingAddress> getBillingAddressById(Long id) {
        return userService.getBillingAddressById(id);
    }

    @Override
    public void deleteUserByEmail(String email) {
        userService.deleteUserByEmail(email);
    }

    @Override
    public void insertAdmin(UserData userData) {
        userService.insertAdmin(reverseConverter.convert(userData));
    }

    @Override
    public void insertCustomer(UserData userData) {
        userService.insertCustomer(reverseConverter.convert(userData));
    }

    @Override
    public List<UserData> listAllUsers() {
        List<User> users = userService.listAllUsers();
        return converter.convertAll(users);
    }

    @Override
    public Optional<User> getByPhoneNumber(String phoneNumber) {
        return userService.getByPhoneNumber(phoneNumber);
    }

}
