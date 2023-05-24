package com.service.spring.controller;

import com.service.spring.domain.UserSkillVO;
import com.service.spring.service.UserSkillService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserSkillController {

    private final UserSkillService userSkillService;

    @Autowired
    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserSkill(@RequestBody UserSkillVO vo) {
        try {
            int result = userSkillService.registerUserSkill(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUserSkill(@PathVariable int id) {
        try {
            int result = userSkillService.deleteUserSkill(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserSkill(@RequestBody UserSkillVO vo) {
        try {
            int result = userSkillService.updateUserSkill(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSkillVO> getUserSkill(@PathVariable int id) {
        try {
            UserSkillVO result = userSkillService.getUserSkill(id);
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
    public ResponseEntity<List<UserSkillVO>> getAllUserSkill(@PathVariable int seekerId) {
        try {
            List<UserSkillVO> userSkills = userSkillService.getAllUserSkill(seekerId);
            return new ResponseEntity<>(userSkills, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
