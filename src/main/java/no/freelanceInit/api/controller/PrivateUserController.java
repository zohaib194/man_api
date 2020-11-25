package no.freelanceInit.api.controller;

import no.freelanceInit.api.data.message.ResponseMessage;
import no.freelanceInit.api.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/v1/api/private/user")
public class PrivateUserController {
    @Resource
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage deleteUser(@PathVariable("userId") Long userId) {
        return userService.deleteUserByID(userId);
    }
}
