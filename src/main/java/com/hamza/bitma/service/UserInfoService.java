package com.hamza.bitma.service;

import com.hamza.bitma.dto.mapperInterface.IMapperDto;
import com.hamza.bitma.dto.model.UserInfoDto;
import com.hamza.bitma.entity.UserInfo;
import com.hamza.bitma.repository.UserInfoRepository;
import com.hamza.bitma.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final IMapperDto<UserInfo,UserInfoDto> userInfoMapper;

    public UserInfoDto getUserInfo(Long userId) {
        UserInfo userInfo = userInfoRepository.findByUser(userId);
        return userInfoMapper.convertToDto(userInfo, UserInfoDto.class);
    }

    public UserInfoDto saveUserInfo(UserInfoDto userInfoDto) {
        UserInfo userInfo = userInfoMapper.convertToEntity(userInfoDto, UserInfo.class);
        userInfo = userInfoRepository.save(userInfo);
        return userInfoMapper.convertToDto(userInfo, UserInfoDto.class);
    }


    public ResponseEntity<String> saveUserAvatar(MultipartFile avatar, Long userId) {
        FileUtil.createDirIfNotExist();
        String fileName = userId + FileUtil.getExtension(Objects.requireNonNull(avatar.getOriginalFilename()));
        String filePath = FileUtil.folderPath + "/avatars" + fileName;
        try {
            avatar.transferTo(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserInfo userInfo = userInfoRepository.findByUser(userId);
        userInfo.setAvatar(fileName);
        userInfoRepository.save(userInfo);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
