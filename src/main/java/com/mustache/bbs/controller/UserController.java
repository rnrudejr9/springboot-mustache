package com.mustache.bbs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        UserDto userDto = userService.join(request.getUserName(), request.getPassword());
        UserJoinResponse response = UserJoinResponse.fromUser(userDto);
        return Response.success(response);
    }
}
