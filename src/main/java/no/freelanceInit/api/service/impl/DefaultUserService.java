package no.freelanceInit.api.service.impl;

import no.freelanceInit.api.entity.User;
import no.freelanceInit.api.repository.UserRepository;
import no.freelanceInit.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);

    @Resource
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        LOGGER.info("User is being stored in DB!");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.info("Users are being fetched from DB!");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        LOGGER.info("User is being fetched based on given ID from DB!");
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public User updateUser(User user, Long userId) {
        LOGGER.info("User is being updated in DB!");

        Optional<User> oldUserData = userRepository.findById(userId);
        User newUser;
        if(!oldUserData.isPresent()) {
            LOGGER.error("User with given ID not found!");
            return null;
        }

        newUser = user;

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void deleteUserByID(Long userId) {
        userRepository.deleteById(userId);;
    }
}
