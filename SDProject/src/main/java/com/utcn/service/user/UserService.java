package com.utcn.service.user;

import com.utcn.model.BillingAddress;
import com.utcn.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void insertAdmin(User user);

    void insertCustomer(User user);

    void updateUserAccount(User user);

    Optional<User> getUserByEmail(String email);

    Optional<BillingAddress> getBillingAddressById(Long id);

    void deleteUserByEmail(String email);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    List<User> listAllUsers();

    Optional<User> getByPhoneNumber(String phoneNumber);
}
