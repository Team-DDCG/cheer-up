package com.service.spring.controller;

import com.service.spring.domain.UserSeekerVO;
import com.service.spring.service.UserSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seekers")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserSeekerController {

    private final UserSeekerService userSeekerService;

    @Autowired
    public UserSeekerController(UserSeekerService userSeekerService) {
        this.userSeekerService = userSeekerService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserSeeker(@RequestBody UserSeekerVO vo) {
        try {
            int result = userSeekerService.registerUserSeeker(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUserSeeker(@PathVariable int id) {
        try {
            int result = userSeekerService.deleteUserSeeker(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserSeeker(@RequestBody UserSeekerVO vo) {
        try {
            int result = userSeekerService.updateUserSeeker(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserSeekerVO> getUserSeeker(@PathVariable int userId) {
        try {
            UserSeekerVO result = userSeekerService.getUserSeeker(userId);
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
