package com.company.repositories.interfaces;

import com.company.entities.User;

import java.util.List;

public interface IUsersRepositories {
    boolean CreateUser(User user);
    User SignIn(User userToCheck);
    boolean isEmpty ();
    boolean isExist(User user);
    List<User> getAllUsers();
}
