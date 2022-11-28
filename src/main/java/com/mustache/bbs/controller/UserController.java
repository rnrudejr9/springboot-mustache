package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.user.UserDto;
import com.mustache.bbs.domain.dto.user.UserJoinRequest;
import com.mustache.bbs.domain.dto.user.UserJoinResponse;
import com.mustache.bbs.domain.dto.user.UserResponse;
import com.mustache.bbs.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public UserResponse<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        UserDto userDto = userService.join(request.getUserName(), request.getPassword());
        UserJoinResponse response = UserJoinResponse.fromUser(userDto);
        return UserResponse.success(response);
    }
}
