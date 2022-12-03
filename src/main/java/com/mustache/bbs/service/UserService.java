package com.mustache.bbs.service;


import com.mustache.bbs.domain.dto.user.UserDto;
import com.mustache.bbs.domain.dto.user.UserJoinRequest;
import com.mustache.bbs.domain.entity.User;
import com.mustache.bbs.exception.ErrorCode;
import com.mustache.bbs.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserDto join(UserJoinRequest request){

        // userName이 중복되었으면 회원가입X -> Exception(예외) 발생

        userRepository.findByUserName(request.getUserName())
                .ifPresent(user-> {
                    try {
                        throw new HospitalReviewAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("UserName:%s", request.getUserName()));
                    } catch (HospitalReviewAppException e) {
                        throw new RuntimeException(e);
                    }
                });



        // save는 entity의 형태를 받음 -> entity로 변환해줌
        User savedUser = userRepository.save(request.toEntity());
        log.info(savedUser.getUserName());

        return UserDto.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .emailAddress(savedUser.getEmailAddress())
                .build();
    }


}
