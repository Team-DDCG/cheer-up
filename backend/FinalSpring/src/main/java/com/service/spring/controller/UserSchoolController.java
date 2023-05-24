package com.service.spring.controller;

import com.service.spring.domain.UserSchoolVO;
import com.service.spring.service.UserSchoolService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserSchoolController {

    private final UserSchoolService userSchoolService;

    @Autowired
    public UserSchoolController(UserSchoolService userSchoolService) {
        this.userSchoolService = userSchoolService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserSchool(@RequestBody UserSchoolVO vo) {
        try {
            int result = userSchoolService.registerUserSchool(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{schoolId}")
    public ResponseEntity<Integer> deleteUserSchool(@PathVariable int schoolId) {
        try {
            int result = userSchoolService.deleteUserSchool(schoolId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserSchool(@RequestBody UserSchoolVO vo) {
        try {
            int result = userSchoolService.updateUserSchool(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSchoolVO> getUserSchool(@PathVariable int id) {
        try {
            UserSchoolVO result = userSchoolService.getUserSchool(id);
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
    public ResponseEntity<List<UserSchoolVO>> getAllUserSchool(@PathVariable int seekerId) {
        try {
            List<UserSchoolVO> userSchools = userSchoolService.getAllUserSchool(seekerId);
            return ResponseEntity.ok(userSchools);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
