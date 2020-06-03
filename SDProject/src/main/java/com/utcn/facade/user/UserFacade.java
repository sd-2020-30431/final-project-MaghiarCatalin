package com.utcn.facade.user;


import com.utcn.data.user.UserData;
import com.utcn.data.user.UserViewData;
import com.utcn.model.BillingAddress;
import com.utcn.model.User;

import java.util.List;
import java.util.Optional;

public interface UserFacade {

    void updateUserAccount(String email, UserViewData userViewData);

    Optional<User> getUserByEmail(String email);

    Optional<BillingAddress> getBillingAddressById(Long id);

    void deleteUserByEmail(String email);

    void insertAdmin(UserData userData);


    void insertCustomer(UserData userData);

    List<UserData> listAllUsers();

    Optional<User> getByPhoneNumber(String phoneNumber);
}
