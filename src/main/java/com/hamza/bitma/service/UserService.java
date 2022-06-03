package com.hamza.bitma.service;

import com.hamza.bitma.dto.mapperInterface.IMapperDto;
import com.hamza.bitma.dto.model.UserDto;
import com.hamza.bitma.entity.User;
import com.hamza.bitma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final IMapperDto<User, UserDto> userMapper;

    public UserDto save(UserDto userDto) {
        log.info("Saving user with username: {}", userDto.getUsername());
        User user = userMapper.convertToEntity(userDto, User.class);
        user = userRepository.save(user);
        return userMapper.convertToDto(user, UserDto.class);
    }

    public List<UserDto> findAll() {
        log.info("Retrieving all users");
        return userMapper.convertListToListDto(userRepository.findAll(), UserDto.class);
    }
}
