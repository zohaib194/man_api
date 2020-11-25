package no.freelanceInit.api.service.impl;

import no.freelanceInit.api.data.entity.User;
import no.freelanceInit.api.data.message.ResponseMessage;
import no.freelanceInit.api.factory.ResponseMessageFactory;
import no.freelanceInit.api.repository.UserRepository;
import no.freelanceInit.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);

    @Resource
    private UserRepository userRepository;

    @Resource
    private ResponseMessageFactory responseMessageFactory;

    @Override
    public ResponseMessage saveUser(User user) {
        LOGGER.info("User is being stored in DB!");

        try {
            User newUser = userRepository.save(user);
            if (newUser == null) {
                return responseMessageFactory.parseOnError("Unable to store the user!", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }
            return responseMessageFactory.parseOnSuccess("User is saved in DB", HttpStatus.CREATED, Collections.singletonList(newUser));

        } catch (Exception e) {
            return responseMessageFactory.parseOnError("User with given email already exists!", HttpStatus.BAD_REQUEST, null);
        }
    }

    @Override
    public ResponseMessage getAllUsers() {
        LOGGER.info("Users are being fetched from DB!");
        List<User> users = userRepository.findAll();
        if (users.size() == 0) {
            return responseMessageFactory.parseOnError("No users found in DB!", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return responseMessageFactory.parseOnSuccess("Users are fetched.", HttpStatus.OK, users);
    }

    @Override
    public ResponseMessage getUserById(Long userId) {
        LOGGER.info("User is being fetched based on given ID from DB!");
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return responseMessageFactory.parseOnError("No content with given ID " + userId, HttpStatus.NO_CONTENT, null);
        }
        return responseMessageFactory.parseOnSuccess("User is fetched from DB", HttpStatus.OK, Collections.singletonList(user.get()));
    }

    @Override
    public ResponseMessage updateUser(User user, Long userId) {
        LOGGER.info("User is being updated in DB!");

        try {
            Optional<User> oldUserData = userRepository.findById(userId);
            if (oldUserData.isEmpty()) {
                LOGGER.error("User with given ID not found!");
                return responseMessageFactory.parseOnError("No content with given ID " + userId, HttpStatus.NO_CONTENT, null);
            }

            userRepository.updateUserInfo(user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getEmail(), user.getMobileNr(), user.getPwd(), userId);
            user.setUserId(userId);
            return responseMessageFactory.parseOnSuccess("User is updated", HttpStatus.OK, Collections.singletonList(user));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e.getStackTrace());
            return responseMessageFactory.parseOnError("User with given email already exists!", HttpStatus.BAD_REQUEST, null);
        }
    }

    @Override
    public ResponseMessage deleteUserByID(Long userId) {
        LOGGER.info("User is being deleted in DB!");
        try {
            userRepository.deleteById(userId);

            return responseMessageFactory.parseOnSuccess("User with id " + userId + " is deleted", HttpStatus.OK, null);
        } catch(Exception e) {
            LOGGER.error(e.getMessage(), e.getStackTrace());
            return responseMessageFactory.parseOnError("User does not exists!", HttpStatus.BAD_REQUEST, null);
        }
    }
}
