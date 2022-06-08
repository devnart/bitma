package com.hamza.bitma.controller;

import com.hamza.bitma.dto.model.UserInfoDto;
import com.hamza.bitma.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/userInfo")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;
    @GetMapping("{userId}")
    public UserInfoDto getUserInfo(@PathVariable Long userId) {
        return userInfoService.getUserInfo(userId);
    }

    @PostMapping("/save")
    public UserInfoDto saveUserInfo(@RequestBody UserInfoDto userInfoDto) {
        return userInfoService.saveUserInfo(userInfoDto);
    }

    @PostMapping("/avatar")
    public ResponseEntity<String> saveUserAvatar(@RequestParam MultipartFile avatar, @RequestParam Long userId) {
        return userInfoService.saveUserAvatar(avatar, userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserInfo(@PathVariable Long userId) {
        return userInfoService.deleteUserInfo(userId);
    }
}
