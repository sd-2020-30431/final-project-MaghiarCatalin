package com.utcn.dao.user;

import com.utcn.model.User;
import com.utcn.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> getUserByEmail(String email);

    void update(User updatedUser);

    void delete(String email);

    List<User> getAll();

    void save(User value);

    Optional<User> getByPhoneNumber(String phoneNumber);

    List<String> getAllUserEmailsByRole(UserRole role);
}
