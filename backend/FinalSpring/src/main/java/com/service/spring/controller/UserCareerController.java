package com.service.spring.controller;

import com.service.spring.domain.UserCareerVO;
import com.service.spring.service.UserCareerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/careers")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserCareerController {

    private final UserCareerService userCareerService;

    @Autowired
    public UserCareerController(UserCareerService userCareerService) {
        this.userCareerService = userCareerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> registerUserCareer(@RequestBody UserCareerVO vo) {
        try {
            int result = userCareerService.registerUserCareer(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Integer> updateUserCareer(@RequestBody UserCareerVO vo) {
        try {
            int result = userCareerService.updateUserCareer(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{carrerId}")
    public ResponseEntity<Integer> deleteUserCareer(@PathVariable int carrerId) {
        try {
            int result = userCareerService.deleteUserCareer(carrerId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{carrerId}")
    public ResponseEntity<UserCareerVO> getUserCareer(@PathVariable int carrerId) {
        try {
            UserCareerVO result = userCareerService.getUserCareer(carrerId);
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/seeker/{seekerId}")
    public ResponseEntity<List<UserCareerVO>> getAllUserCareer(@PathVariable int seekerId) {
        try {
            List<UserCareerVO> userCareerList = userCareerService.getAllUserCareer(seekerId);
            if (!userCareerList.isEmpty()) {
                return ResponseEntity.ok(userCareerList);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}