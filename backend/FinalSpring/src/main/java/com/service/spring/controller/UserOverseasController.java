package com.service.spring.controller;

import com.service.spring.domain.UserOverseasVO;
import com.service.spring.service.UserOverseasService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/overseas")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserOverseasController {

    private final UserOverseasService userOverseasService;

    @Autowired
    public UserOverseasController(UserOverseasService userOverseasService) {
        this.userOverseasService = userOverseasService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserOverseas(@RequestBody UserOverseasVO vo) {
        try {
            int result = userOverseasService.registerUserOverseas(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{overseasId}")
    public ResponseEntity<Integer> deleteUserOverseas(@PathVariable int overseasId) {
        try {
            int result = userOverseasService.deleteUserOverseas(overseasId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserOverseas(@RequestBody UserOverseasVO vo) {
        try {
            int result = userOverseasService.updateUserOverseas(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOverseasVO> getUserOverseas(@PathVariable int id) {
        try {
            UserOverseasVO result = userOverseasService.getUserOverseas(id);
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/all/{seekerId}")
    public ResponseEntity<List<UserOverseasVO>> getAllUserOverseas(@PathVariable int seekerId) {
        try {
            List<UserOverseasVO> result = userOverseasService.getAllUserOverseas(seekerId);
            if (!result.isEmpty()) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}