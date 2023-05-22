package com.service.spring.controller;

import com.service.spring.domain.UserMentorVO;
import com.service.spring.service.UserMentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-mentors")
public class UserMentorController {

    private final UserMentorService userMentorService;

    @Autowired
    public UserMentorController(UserMentorService userMentorService) {
        this.userMentorService = userMentorService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserMentor(@RequestBody UserMentorVO vo) {
        try {
            int result = userMentorService.registerUserMentor(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUserMentor(@PathVariable int id) {
        try {
            int result = userMentorService.deleteUserMentor(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserMentor(@RequestBody UserMentorVO vo) {
        try {
            int result = userMentorService.updateUserMentor(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMentorVO> getUserMentor(@PathVariable int id) {
        try {
            UserMentorVO result = userMentorService.getUserMentor(id);
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