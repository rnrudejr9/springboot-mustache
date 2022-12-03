package com.mustache.bbs.domain.dto.user;

import com.mustache.bbs.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String userName;
    private String password;
    private String emailAddress;



}
