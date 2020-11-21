package no.freelanceInit.api.controller;

import no.freelanceInit.api.entity.User;

import java.util.List;

public interface UserController {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
    User updateUser(User user, Long userId);
    void deleteUser(Long userId);
}
