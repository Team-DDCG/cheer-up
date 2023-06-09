package com.service.spring.controller;

import com.service.spring.domain.UserRewardVO;
import com.service.spring.service.UserRewardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rewards")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserRewardController {

    private final UserRewardService userRewardService;

    @Autowired
    public UserRewardController(UserRewardService userRewardService) {
        this.userRewardService = userRewardService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserReward(@RequestBody UserRewardVO vo) {
        try {
            int result = userRewardService.registerUserReward(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{rewardId}")
    public ResponseEntity<Integer> deleteUserReward(@PathVariable int rewardId) {
        try {
            int result = userRewardService.deleteUserReward(rewardId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserReward(@RequestBody UserRewardVO vo) {
        try {
            int result = userRewardService.updateUserReward(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRewardVO> getUserReward(@PathVariable int id) {
        try {
            UserRewardVO result = userRewardService.getUserReward(id);
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
    public ResponseEntity<List<UserRewardVO>> getAllUserReward(@PathVariable int seekerId) {
        try {
            List<UserRewardVO> userRewards = userRewardService.getAllUserReward(seekerId);
            return ResponseEntity.ok(userRewards);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/number/{seekerId}")
    public ResponseEntity<Integer> getRewardNumber(@PathVariable int seekerId) {
        try {
            int rewardNumber = userRewardService.getRewardNumber(seekerId);
            return ResponseEntity.ok(rewardNumber);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
