package com.mustache.bbs.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse<T> {
    private String resultCode;
    private T result;
    public static UserResponse<Void> error(String resultCode){
        return new UserResponse(resultCode,null);
    }
    public static UserResponse<T> success(T result){
        return new UserResponse("success",result);
    }

}
