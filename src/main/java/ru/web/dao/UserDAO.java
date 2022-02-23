package ru.web.dao;

import ru.web.model.User;

import java.util.List;

public interface UserDAO {
    void createUsersTable();
    void dropUsersTable();
    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUser(long id);
    List<User> getAllUsers();
}
