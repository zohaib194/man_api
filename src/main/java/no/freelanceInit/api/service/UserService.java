package no.freelanceInit.api.service;

import no.freelanceInit.api.data.entity.User;
import no.freelanceInit.api.data.message.ResponseMessage;


public interface UserService {
    ResponseMessage saveUser(User user);

    ResponseMessage getAllUsers();

    ResponseMessage getUserById(Long userId);

    ResponseMessage updateUser(User user, Long userId);

    ResponseMessage deleteUserByID(Long userId);
}
