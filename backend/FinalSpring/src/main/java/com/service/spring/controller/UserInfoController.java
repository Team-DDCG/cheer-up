package com.service.spring.controller;

import com.service.spring.domain.UserInfoVO;
import com.service.spring.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user-info")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUserInfo(@RequestBody UserInfoVO userInfo) {
        try {
            int result = userInfoService.registerUserInfo(userInfo);
            if (result > 0) {
                return ResponseEntity.ok("User info registered successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user info.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user info.");
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUserInfo(@PathVariable int userId) {
        try {
            int result = userInfoService.deleteUserInfo(userId);
            if (result > 0) {
                return ResponseEntity.ok("User info deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user info.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user info.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUserInfo(@RequestBody UserInfoVO userInfo) {
        try {
            int result = userInfoService.updateUserInfo(userInfo);
            if (result > 0) {
                return ResponseEntity.ok("User info updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user info.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user info.");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoVO> getUserInfo(@PathVariable int userId) {
        try {
            UserInfoVO userInfo = userInfoService.getUserInfo(userId);
            if (userInfo != null) {
                return ResponseEntity.ok(userInfo);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/find/{name}/{phone}")
    public ResponseEntity<String> findUserId(@PathVariable String name, @PathVariable String phone) {
        try {
            String userId = userInfoService.findUserId(name, phone);
            if (userId != null) {
                return ResponseEntity.ok(userId);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/find/{name}/{id}/{email}")
    public ResponseEntity<String> findUserPassword(@PathVariable String name, @PathVariable String id, @PathVariable String email) {
        try {
            String userInfo = userInfoService.findUserPassword(name, id, email);
            if (userInfo != null) {
                return ResponseEntity.ok(userInfo);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfoVO> login(@RequestBody UserInfoVO userInfo) {
        try {
            UserInfoVO loggedInUser = userInfoService.login(userInfo);
            if (loggedInUser != null) {
                return ResponseEntity.ok(loggedInUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 다른 메소드들도 마찬가지로 작성

}