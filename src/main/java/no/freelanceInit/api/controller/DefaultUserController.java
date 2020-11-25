package no.freelanceInit.api.controller;

import no.freelanceInit.api.data.entity.User;
import no.freelanceInit.api.data.message.ResponseMessage;
import no.freelanceInit.api.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/v1/api/user")
public class DefaultUserController {

    @Resource
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage updateUser(@RequestBody User user, @PathVariable Long userId) {
        return userService.updateUser(user, userId);
    }
}
