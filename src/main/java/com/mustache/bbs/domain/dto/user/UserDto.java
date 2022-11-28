package com.mustache.bbs.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private UserRole userRole;


    public static UserDto fromEntity(User entity) {
        return new UserDto(entity.getId(), entity.getUserName(), entity.getPassword(), entity.getRole());
    }
}
