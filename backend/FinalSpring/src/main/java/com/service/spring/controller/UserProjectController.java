package com.service.spring.controller;

import com.service.spring.domain.UserProjectVO;
import com.service.spring.service.UserProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserProjectController {

    private final UserProjectService userProjectService;

    @Autowired
    public UserProjectController(UserProjectService userProjectService) {
        this.userProjectService = userProjectService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserProject(@RequestBody UserProjectVO vo) {
        try {
            int result = userProjectService.registerUserProject(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUserProject(@PathVariable int id) {
        try {
            int result = userProjectService.deleteUserProject(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserProject(@RequestBody UserProjectVO vo) {
        try {
            int result = userProjectService.updateUserProject(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProjectVO> getUserProject(@PathVariable int id) {
        try {
            UserProjectVO result = userProjectService.getUserProject(id);
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
    public ResponseEntity<List<UserProjectVO>> getAllUserProject(@PathVariable int seekerId) {
        try {
            List<UserProjectVO> result = userProjectService.getAllUserProject(seekerId);
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