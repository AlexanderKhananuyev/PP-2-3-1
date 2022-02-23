package ru.web.service;

import ru.web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    void updateUserById(long id, User user);
    void deleteUser(User user);
    void deleteUserById(long id);
    User getUser(long id);
    List<User> getAllUsers();
}
