package com.mustache.bbs.service;


import com.mustache.bbs.domain.dto.user.UserDto;
import com.mustache.bbs.domain.entity.User;
import com.mustache.bbs.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto join(String userName, String password) {
        // 중복 Check
        userRepository.findByUserName(userName).ifPresent(user -> {
        throw new HospitalReviewAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("UserName %s is
        duplicated", userName));
        });
        // 위에서 에러가 안났다면 회원가입(DB에 저장)
        User savedUser = userRepository.save(User.of(userName, encoder.encode(password)));
        return UserDto.fromEntity(savedUser);
        }
}

