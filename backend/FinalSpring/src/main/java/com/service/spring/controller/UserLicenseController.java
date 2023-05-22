package com.service.spring.controller;

import com.service.spring.domain.UserLicenseVO;
import com.service.spring.service.UserLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-licenses")
public class UserLicenseController {

    private final UserLicenseService userLicenseService;

    @Autowired
    public UserLicenseController(UserLicenseService userLicenseService) {
        this.userLicenseService = userLicenseService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserLicense(@RequestBody UserLicenseVO vo) {
        try {
            int result = userLicenseService.registerUserLicnse(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUserLicense(@PathVariable int id) {
        try {
            int result = userLicenseService.deleteUserLicense(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserLicense(@RequestBody UserLicenseVO vo) {
        try {
            int result = userLicenseService.updateUserLicense(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLicenseVO> getUserLicense(@PathVariable int id) {
        try {
            UserLicenseVO result = userLicenseService.getUserLicense(id);
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}