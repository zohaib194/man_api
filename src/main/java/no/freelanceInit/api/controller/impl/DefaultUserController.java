package no.freelanceInit.api.controller.impl;

import no.freelanceInit.api.controller.UserController;
import no.freelanceInit.api.entity.User;
import no.freelanceInit.api.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
public class DefaultUserController implements UserController {

    @Resource
    private UserService userService;

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(Long userId) {
        return userService.getUserById(userId);
    }

    @Override
    @PutMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user, @PathVariable Long userId) {
        return userService.updateUser(user, userId);
    }

    @Override
    @DeleteMapping(value = "/{bookID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(Long userId) {
        userService.deleteUserByID(userId);
    }
}
