package no.freelanceInit.api.service;

import no.freelanceInit.api.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
    User updateUser(User user, Long userId);
    void deleteUserByID(Long userId);
}
