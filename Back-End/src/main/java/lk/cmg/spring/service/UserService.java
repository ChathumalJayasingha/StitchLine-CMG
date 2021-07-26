package lk.cmg.spring.service;


import lk.cmg.spring.model.User;

import java.util.List;

public interface UserService {
    void addUser(User dto);
    void updateUser(User dto);
    void deleteUser(String id);
    List<User> getAllUsers();
    User searchUser(String id);
    User findByUserName(String userName);
}
